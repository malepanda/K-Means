
package k.means;

import java.util.ArrayList;

/**
 *
 * @author malepanda
 */
public class Centroid {
    private ArrayList<Points> points = new ArrayList<>();
    private Points mean = new Points(null);
    
    public void insertPoint (Points p_point){
        getPoints().add(p_point);
    }
    
    public void clean(){
        points.clear();
    }
    
    public Points calculateMeans (){
        Points res = new Points(new Float[]  {0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        int n = getPoints().size();
        int m = 4;
        
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                res.getValue().set(j, (getPoints().get(i).getValue().get(j) + res.getValue().get(j)) );
            }
        }
        
        for (int i=0; i<m; i++)
            res.getValue().set(i, (res.getValue().get(i) / (float)n));
        
        return res;
    }

    /**
     * @return the points
     */
    public ArrayList<Points> getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(ArrayList<Points> points) {
        this.points = points;
    }

    /**
     * @return the mean
     */
    public Points getMean() {
        return mean;
    }

    /**
     * @param mean the mean to set
     */
    public void setMean(Points mean) {
        this.mean = mean;
    }
}
