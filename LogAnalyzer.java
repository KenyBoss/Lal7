/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String filename)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader(filename);
    }

    
    
    public void printGreater( double mean){
        
        double[] marks ={ 1.1,5.7,6.6,9.2,10.4};
        
        for(int index=0 ; index <marks.length;index++){
            if (marks[index]> mean){
                System.out.println(marks[index]);
            }
        }
    }
    
    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        int hour = 0;
        while (hour < hourCounts.length) {
            System.out.println(hour + ": " + hourCounts[hour]);
            hour++;
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
         public int numberOfAccesses() {
        int total = 0;
        for (int count : hourCounts) {
            total += count;
        }
        return total;
    }
    
     public String busiestHour(){
         int maxCount = 0;
         int busiestHour = -1;
         for ( int i=0; i < hourCounts.length;i++){
             if (hourCounts[i]> maxCount){
                 maxCount = hourCounts[i];
                 busiestHour= i;
             }
             }
             return busiestHour + " is the busiest hour";
     }
     
     public String quiestestHour(){
         int lowCount= hourCounts[0];
         int quietestHour= 0;
         for (int i = 1; i < hourCounts.length;i++){
             if(hourCounts[i]< lowCount){
                 lowCount = hourCounts[i];
                 quietestHour= i;
             }
         }
         return quietestHour + " is the quiesteshour";
     }
        
        
        
    }
    
    /*
     * 
     *1.Busiest time of the say is hour 18
    //2.privaye int[] person = {}
    //3. private boolean {} vacant={};
    //5. 1- the[] before the int
    //   2- 2 boolean [] occupied = new boolean[500];
    //6. double[60] readings;
     String[90] urls;
    7. 20 Strings
    8. It should be new double[50];
    9. Its out of bonds of 24
    11.
    public void printGreater( double mean){
        for( index=0 ; index <= marks.length;index++){
            if (marks(index)> mean){
                System.outprintln(marks[index]);
            }
        }
    }
    13.
    */

