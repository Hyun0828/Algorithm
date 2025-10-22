import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<Job> pq = new PriorityQueue<>();        
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        
        int[] arr = new int[jobs.length];
        int currentJobIdx = -1;
        int currentTime = 0;
        int runningJobStartTime = 0;
        boolean isRunning = false;
        Job runningJob = null;
        int jobCount = 0;
        
        while(true) {
            // 작업 큐에 넣는다.
            for(int i=currentJobIdx + 1; i<jobs.length; i++){
                int start = jobs[i][0];
                int play = jobs[i][1];

                if(currentTime >= start){        
                    pq.add(new Job(play, start, i));
                    currentJobIdx = i;
                }   
            }
            
            // 작업이 끝났으면
            if(runningJob != null && runningJobStartTime + runningJob.play == currentTime){
                answer += (currentTime - runningJob.start);
                runningJob = null;
                isRunning = false;
                jobCount++;
            }
            
            if(jobCount == jobs.length){
                break;
            }
            
            if(!isRunning && !pq.isEmpty()){
                runningJob = pq.poll();
                runningJobStartTime = currentTime;
                isRunning = true;
            }
            
            currentTime++;
        }

        return answer / jobCount;
    }
    
    
    public static class Job implements Comparable<Job>{
        int play;
        int start;
        int idx;
        
        public Job(int play, int start, int idx){
            this.play = play;
            this.start = start;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Job j){
            if(this.play == j.play){
                if(this.start == j.start){
                    return this.idx - j.idx;
                } else{
                    return this.start - j.start;
                }
            } else {
                return this.play - j.play;
            }
        }
    }
}