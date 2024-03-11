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



        int numOfDiscountedB = Math.min(countOfFreeB,countB);

        return numOfDiscountedB*30;
//        return evenB*15;

    }

    private int calulateDiscounts(int countA){
        int totalDiscountValue=0;
        int numOfDiscount5=0;
        int numOfDiscount3=0;
        //Check how many times we can apply discount
        if(countA%5==0){
            numOfDiscount5 +=countA/5;
            countA%=5;

            if(countA%3==0){
                numOfDiscount3+=countA/3;
            }
        }else if(countA%3==0){
            numOfDiscount3+=countA;
        }
        if(numOfDiscount5>0){
            totalDiscountValue+= numOfDiscount5*50;
        }

        if(numOfDiscount3>0){
            totalDiscountValue+= numOfDiscount3*20;
        }
        return totalDiscountValue;

    }
}
