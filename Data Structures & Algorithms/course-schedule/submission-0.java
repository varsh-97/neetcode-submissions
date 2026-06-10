class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       // build inDeg[] -> num of prereq for each course
       // build the adj list -> each index as preReq and list of courses it unlocks
       // queue and totalcourses polled == numcourses ? true : false 

       int[] inDeg = new int[numCourses];
       List<List<Integer>> adj = new ArrayList<>();
       Queue<Integer> queue = new LinkedList<>();
       int count = 0;

       for(int i=0; i<numCourses; i++) // adj priming
       {
            adj.add(new ArrayList<>());
       }
       // populating inDeg and adj
       for(int[] pre : prerequisites)
       {
            int course = pre[0];
            int preReq = pre[1];

            adj.get(preReq).add(course);
            inDeg[course]++;
       }
       // add 0 inDeg courses to queue
       for(int i=0; i<numCourses; i++)
       {
            if(inDeg[i] == 0) queue.offer(i);
       }

       while(!queue.isEmpty())
       {
            int curr = queue.poll(); 
            count++;

            for(int courses : adj.get(curr))
            {
                inDeg[courses]--;
                if(inDeg[courses] == 0)
                {
                    queue.offer(courses);
                }
            }
       }

       return count==numCourses ? true : false;
    }
}
