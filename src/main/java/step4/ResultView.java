package step4;

import java.util.List;

public class ResultView {
    public static void printRound() {
        System.out.println();
    }

    public static void printTotal() {
        System.out.println();
    }

    public static void printWinner(List<Car> carList){
        for(int i=0; i<carList.size();i++){
            if(i>0) System.out.print(",");
            System.out.print(carList.get(i).getName());
        }
        System.out.println("가 최종 우승했습니다.");

    }
    public static void foward(String name,int position){
        System.out.print(name + " : ");
        for(int i=0; i<position; i++){
            System.out.print("-");
        }
    }
}
