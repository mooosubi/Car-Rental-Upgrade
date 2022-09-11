

//this class does the bulk of calculations
//for the project
public class CalculationsClass {

  //declare class variables
  private double dblBegOd, dblEndOd, dblMiles, dblDays, dblCost, dblAverage;

  private static int totalNumPeople = 0;
  private static double totalReceived = 0.00;  

  //create a class constructor
  //its the first method that runs in the class
  //it really just sets things up
  //the constructor has the same name as the class

  CalculationsClass(double theBegOd, double theEndOd, double theDays)
  {
    dblBegOd = theBegOd;
    dblEndOd = theEndOd;
    dblDays = theDays;
  }
  private void CalculatePay()
  {
    dblMiles = dblEndOd - dblBegOd;
    dblCost = dblMiles * 0.12 + dblDays * 15;
    totalNumPeople++;
    totalReceived += dblCost;
  }
  public double getCost()
  {
    CalculatePay();
    return dblCost;
  }
  public double getTotalDay()
  {
    return totalReceived;
  }
  public double getAverageCost()
  {
    AverageCost();
    return dblAverage;
  }
  private void AverageCost()
  {
    dblAverage = totalReceived / totalNumPeople;
  }
  public int getEmployeeCount()
  {
    return totalNumPeople;
  }
}
