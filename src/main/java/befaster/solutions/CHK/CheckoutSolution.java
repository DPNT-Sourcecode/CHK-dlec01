package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {
         return calculateStringValue(skus);


    }

    private int calculateStringValue(String str){
        int totalValue = 0;

        for(int i=0; i<str.length(); i++){
            char letter = str.charAt(i);
            switch(letter){
                case 'A':
                    totalValue+=50;
                    break;
                case'B':
                    totalValue+=30;
                    break;
                case 'C':
                    totalValue+=20;
                    break;
                case 'D':
                    totalValue+=15;
                    break;
                default:
                    return -1;

            }
        }
        return totalValue;
    }
}



