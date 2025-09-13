import java.util.*;

class Solution {
    
    PriorityQueue<Job> pq = new PriorityQueue<>();
    int currentTime = 0;
    int jobIndex = -1;
    boolean isRunning = false;
    Job runningJob = null;
    int runningJobStartTime = 0;
    int taTime = 0;
    int jobCount = 0;
    
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        
        while(true){
            // 현재 작업이 요청된다면 작업 큐에 넣는다.
            putJob(jobs, pq, currentTime);
            
            // 작업이 끝났으면
            if(runningJob != null && runningJobStartTime + runningJob.runTime == currentTime){
                taTime += (currentTime - runningJob.startTime);
                runningJob = null;
                isRunning = false;
                jobCount++;
            }
            
            // break : 큐에 작업이 없고, 더이상 작업이 없으면
            if(jobCount == jobs.length)
                break;
            
            // 작업 중이 아니고 대기 중인 작업이 있으면 큐에서 작업을 꺼낸다.
            if(!isRunning && !pq.isEmpty()){
                runningJob = pq.poll();
                runningJobStartTime = currentTime;
                isRunning = true;
            }
            
            currentTime++;
        }
        
        return taTime / jobs.length;
    }
    
    public void putJob(int[][] jobs, PriorityQueue<Job> pq, int currentTime){
        for(int i=jobIndex+1; i<jobs.length; i++){
            int start = jobs[i][0];
            int run = jobs[i][1];
            
            if(start <= currentTime){
                pq.add(new Job(i, start, run));
                jobIndex = i;
            }
        }
    }
    
    public static class Job implements Comparable<Job>{
        int number;
        int startTime;
        int runTime;
        
        public Job(int number, int startTime, int runTime){
            this.number = number;
            this.startTime = startTime;
            this.runTime = runTime;
        }
        
        @Override
        public int compareTo(Job j){
            if(j.runTime == this.runTime){
                if(j.startTime == this.startTime){
                    return this.number - j.number;
                } else {
                    return this.startTime - j.startTime;
                }
            } else {
                return this.runTime - j.runTime;
            }
        }
    }
}