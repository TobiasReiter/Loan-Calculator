import java.util.Scanner;

public class assignment{
    //credit score calculator
    public static double creditScore(int creditModifier, double loanAmount, int loanPeriod){
        double creditScore = (creditModifier / loanAmount) * loanPeriod;
        return creditScore;
    }

    //finding min loan for client, what we can offer him
    public static double minLoan(double creditScore, double loanAmount){
        double value = 1 / creditScore;
        double max = loanAmount/value;
        return max;
    }

    //finding max loan for client,what we can offer him
    public static double maxLoan(int creditModifier, int loanPeriod){
        double loanAmount = creditModifier * loanPeriod;
        return loanAmount;
    }

    //finding the right month for your loan amount
    public static double loanMonth(int creditModifier, double loanAmount, double creditScore){
        double value = 1 - creditScore;
        double loanMonth1 = creditScore / (creditModifier/loanAmount);
        double loanMonth2 = value / (creditModifier/loanAmount);
        double loanMonth = loanMonth1 + loanMonth2;
        return loanMonth;
    }


    public static void main(String[] args) {

        //creating a scanner
        Scanner input = new Scanner(System.in);

        //asking personal code
        System.out.println("Enter your personal code: ");
        long personalCode = input.nextLong();

        //asking loan amount
        System.out.println("Enter the loan amount, (2000 - 10000 eur): ");
        double loanAmount = input.nextDouble();
        while (loanAmount < 2000 || loanAmount > 10000) {
            System.out.println("NB! Loan amount have to be between 2000 - 10000 eur");
            loanAmount = input.nextDouble();
        }

        //asking loan period in months
        System.out.println("Enter loan period in months, (12 - 60 months): ");
        int loanPeriod = input.nextInt();
        while(loanPeriod < 12 || loanPeriod > 60) {
            System.out.println("NB! Loan period have to be between 12 - 60 months");
            loanPeriod = input.nextInt();
        }

        int debt = 0;
        int segment1 = 100;
        int segment2 = 300;
        int segment3 = 1000;

        double credit = creditScore(segment1, loanAmount, loanPeriod);
        double maxLoan = minLoan(credit,loanAmount);
        double minLoan = maxLoan(segment1, loanPeriod);
        int loanMonth = (int) loanMonth(segment1, loanAmount, credit);
        if(maxLoan > 10000)
            maxLoan = 10000;

        //returning a decision + or - And the amount
        if (credit >= 1)
            System.out.println("You can get this amount of money: 3 " + Math.round(maxLoan) + " eur");
        else
            System.out.println("You can not get this amount of money. " +
                    "Change your period to " + loanMonth + ". " + "\n");
        //"At the moment you can get --> " + minLoan + " eur");
    }
}