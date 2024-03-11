package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {
         return calculateStringValue(skus);


    }

    private int calculateStringValue(String str){
        int totalValue = 0;
        int countB =0;
        int countA = 0;
        int countE= 0;

        for(int i=0; i<str.length(); i++){
            char letter = str.charAt(i);
            switch(letter){
                case 'A':
                    totalValue+=50;
                    countA++;
//                    if(countA==3){
//                        countA=0;
//                        totalValue -=20;
//                    }
                    break;
                case'B':
                    totalValue+=30;
                    countB++;
//                    if(countB==2){
//                        countB=0;
//                        totalValue -=15;
//                    }
                    break;
                case 'C':
                    totalValue+=20;
                    break;
                case 'D':
                    totalValue+=15;
                    break;
                case'E':
                    countE++;
                    totalValue+=40;
                    break;
                default:
                    return -1;

            }
        }
         int aDiscount =calulateDiscounts(countA);
        int bNEdisocunt =eBPromotion(countE,countB);
        return totalValue -aDiscount-bNEdisocunt;
    }

    private int eBPromotion(int countE, int countB){
        int countOfFreeB =countE/2;
        while(countB>=1){
            if(countOfFreeB>0){
                countB--;
                countOfFreeB--;
            }
        }

        int evenB = countB/2;
        return evenB*15;

    }

    private int calulateDiscounts(int countA){
        int totalDiscountValue=0;
        while(countA>=5){
            totalDiscountValue+=50;
            countA-=5;
        }
        while (countA>=3){
            totalDiscountValue+=20;
            countA-=3;
        }

        return totalDiscountValue;

    }
}
