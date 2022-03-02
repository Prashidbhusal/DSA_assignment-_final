package week1to8;





import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;





public class Week4 {



        int [][] coordinates;



        Week4(int[][] coordinates){
                this.coordinates = coordinates;



        }



        public String calcSlope(int i, int j) {
                Integer deltaX = this.coordinates[i][0] - this.coordinates[j][0];
                Integer deltaY = this.coordinates[i][1] - this.coordinates[j][1];



                if(deltaX==0)
                        return "horizontal";
                else if(deltaY==0)
                        return "vertical";
                if(deltaX<0) {
                        deltaX = - deltaX;
                        deltaY = -deltaY;
                }



                Integer gcd = BigInteger.valueOf(deltaX).gcd(BigInteger.valueOf(deltaY)).intValue();
                deltaX = deltaX/gcd;
                deltaY = deltaY/gcd;
                String key = deltaX.toString()+'.'+deltaY.toString();
                return key;



        }



        public ArrayList<Integer> findmaxPoints(int i) {
                HashMap<String, ArrayList<Integer>> slopes = new HashMap<String, ArrayList<Integer>>();
                ArrayList<Integer> duplicates = new ArrayList<Integer>();



                for(int j = i+1; j<this.coordinates.length; j++) {
                        if(coordinates[i]==coordinates[j]) {
                                duplicates.add(j);
                                continue;
                        }



                        String slope = calcSlope(i, j);
                        if(slopes.containsKey(slope)) {
                                slopes.get(slope).add(j);



                        }
                        else {
                                slopes.put(slope, new ArrayList<>(Arrays.asList(i,j)));
                        }
                }



                int max_size = 0;
                ArrayList<Integer> max_arr = new ArrayList<Integer>();
                for(ArrayList<Integer> val: slopes.values()) {
                        if(val.size()>max_size) {
                                max_size = val.size();
                                max_arr = val;
                        }
                }
                max_arr.addAll(duplicates);
                return max_arr;




        }





        public double calcLength(ArrayList<Integer> points) {
                int n = points.size();




                int x1 = this.coordinates[points.get(0)][0];
                int y1 = this.coordinates[points.get(0)][1];
                int x2 = this.coordinates[points.get(n-1)][0];
                int y2 = this.coordinates[points.get(n-1)][1];





                return Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));
        }



        public double getLength(){
                ArrayList<Integer> final_arr= new ArrayList<Integer>();
                int n = this.coordinates.length;
                for(int i=0; i<n-1; i++) {
                        ArrayList<Integer> temp = findmaxPoints(i);
                        if(temp.size()>final_arr.size())
                                final_arr = temp;
                }



                double length = calcLength(final_arr);
                return length;



        }



        public static void main(String[] args) {
                int [][] coord = {{1,2}, {5,5}, {1,4}, {2,3}, {3,2}, {4,1}, {3,5}};



                Week4 w = new Week4(coord);



                double res = w.getLength();



                System.out.println(res);
        }






}