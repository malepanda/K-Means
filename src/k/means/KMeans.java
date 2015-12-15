
package k.means;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Muhammad Fakhrian Noor
 */
public class KMeans {

    private static ArrayList<Points> dataset = new ArrayList<>();
    
    public static void main(String[] args) {
        Centroid centroidYes = new Centroid();
        Centroid centroidNo = new Centroid();
        initDataset();
        Random generator = new Random(); 
        int r1=0, r2=0;
        
        //select 2 random points as intial centroids
        while (r1==r2){
            r1 = generator.nextInt(dataset.size()) + 1;
            r2 = generator.nextInt(dataset.size()) + 1;
        }
        centroidYes.insertPoint(dataset.get(r1));
        centroidNo.insertPoint(dataset.get(r2));
        
        //calculate and set the centroid mean
        centroidYes.setMean( centroidYes.calculateMeans() );
        centroidNo.setMean( centroidNo.calculateMeans() );
        
        while (true){
            //assigning all points to the closest centroid
            for (int i=0; i<dataset.size(); i++){
                if (euclidianDistance(dataset.get(i), centroidYes) < euclidianDistance(dataset.get(i), centroidNo))
                    centroidYes.insertPoint(dataset.get(i));
                else
                    centroidNo.insertPoint(dataset.get(i));
            }
            
            //recompute the mean of each centroid
            Points yesMean = centroidYes.calculateMeans();
            Points noMean = centroidYes.calculateMeans();
            
            //check if the mean of each centroid change
            int yesFlag=0, noFlag=0;
            for (int i=0; i< yesMean.getValue().size(); i++){
                if (yesMean.getValue().get(i) != centroidYes.getMean().getValue().get(i)){
                    yesFlag=1; 
                    break;
                }        
            }
            
            for (int i=0; i< noMean.getValue().size(); i++){
                if (noMean.getValue().get(i) != centroidNo.getMean().getValue().get(i)){
                    noFlag=1; 
                    break;
                }        
            }
            
            //if centroid doesn't change then out of while iteration else set new mean to centroid
            if (yesFlag == 0 && noFlag ==0)
                break;
            else if (yesFlag==0)
                centroidNo.setMean(noMean);
            else if (noFlag==0)
                centroidYes.setMean(yesMean);
            else{
                centroidNo.setMean(noMean);
                centroidYes.setMean(yesMean);
            }
            
            centroidNo.clean();
            centroidYes.clean();
        }
        
        for (int i=0; i<centroidYes.getPoints().size(); i++){
            
               System.out.println(centroidYes.getPoints().get(i).getValue().get(0)+" "+centroidYes.getPoints().get(i).getValue().get(1)
                       +" "+centroidYes.getPoints().get(i).getValue().get(2)+" "+centroidYes.getPoints().get(i).getValue().get(3)+" "
                       +centroidYes.getPoints().get(i).getValue().get(4));

            
        }
        
    }
    
    public static float euclidianDistance(Points p_point, Centroid centroid){
        float distance=0;
        
        for (int i=0; i<p_point.getValue().size(); i++){
            distance = (float) (distance + Math.pow(( p_point.getValue().get(i) - centroid.getMean().getValue().get(i)), 2));
        }
        
        
        return (float) Math.sqrt(distance);
    }
    

    
    private static void initDataset(){
        dataset.add(new Points(new Float[]  {1.0f, 1.0f, 1.0f, 1.0f, 1.0f} ));
        dataset.add(new Points(new Float[]  {1.0f, 1.0f, 1.0f, 2.0f, 1.0f} ));
        dataset.add(new Points(new Float[]  {2.0f, 1.0f, 1.0f, 1.0f, 0.0f} ));
        dataset.add(new Points(new Float[]  {3.0f, 2.0f, 1.0f, 1.0f, 0.0f} ));
        dataset.add(new Points(new Float[]  {3.0f, 3.0f, 2.0f, 1.0f, 0.0f} ));
        dataset.add(new Points(new Float[]  {3.0f, 3.0f, 2.0f, 2.0f, 1.0f} ));
        dataset.add(new Points(new Float[]  {2.0f, 3.0f, 2.0f, 2.0f, 0.0f} ));
        dataset.add(new Points(new Float[]  {1.0f, 2.0f, 1.0f, 1.0f, 1.0f} ));
        dataset.add(new Points(new Float[]  {1.0f, 3.0f, 2.0f, 1.0f, 0.0f} ));
        dataset.add(new Points(new Float[]  {3.0f, 2.0f, 2.0f, 1.0f, 0.0f} ));
        dataset.add(new Points(new Float[]  {1.0f, 2.0f, 2.0f, 2.0f, 0.0f} ));
        dataset.add(new Points(new Float[]  {2.0f, 2.0f, 1.0f, 2.0f, 0.0f} ));
        dataset.add(new Points(new Float[]  {2.0f, 1.0f, 2.0f, 1.0f, 0.0f} ));
        dataset.add(new Points(new Float[]  {3.0f, 2.0f, 1.0f, 2.0f, 1.0f} ));
    }
}
