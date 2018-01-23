/**
 * Created by Caleb on 1/19/18.
 */
public class CrazyDay extends ReportCondition {

    public static final float CRAZY_DAY_THRESHOLD=.15f;

    public void processDay(StockDayRow day){
        if(((day.highPrice - day.lowPrice) / day.highPrice) > CRAZY_DAY_THRESHOLD){
            this.results.add(day);
        }
    }

    public String resultsToString(){
        return "";
    }

    public String resultsToString(String StockID){
        return "";
    }

}