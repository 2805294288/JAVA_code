package ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Card{
    private final String color;
    private final String number;

    public Card(String color, String number) {
        this.color = color;
        this.number = number;
    }

    @Override
    public String toString() {
        return "[" + color + "," + number + "]";
    }
}

public class MyCard {
    public static void productCardList(List<Card> cardList){
        String[] colors = {"♣","♦","♠","♥"};
        for(int i = 0; i < 4; i++){
            for(int j = 1; j < 14; j++){
                String number;
                if(j == 1){
                    number = "A";
                }else if(j == 11){
                    number = "J";
                }else if(j == 12){
                    number = "Q";
                }else if(j == 13){
                    number = "K";
                }else{
                    number = j+"";
                }
                Card card = new Card(colors[i],number);
                cardList.add(card);
            }
        }
    }
    public static void swap(List<Card> cardList, int i, int rNumber){
        Card temp = cardList.get(i);
        cardList.set(i,cardList.get(rNumber));
        cardList.set(rNumber,temp);
    }
    public static void washCardList(List<Card> cardList){
        for (int i = cardList.size()-1; i > 0 ; i--) {
            Random random = new Random();
            int rNumber = random.nextInt(i);
            swap(cardList,i,rNumber);
        }
    }
    public static List<List<Card>> playCardList(List<Card> cardList){
        List<List<Card>> handLists = new ArrayList<>();
        List<Card> p1 = new ArrayList<>();
        List<Card> p2 = new ArrayList<>();
        List<Card> p3 = new ArrayList<>();
        handLists.add(p1);
        handLists.add(p2);
        handLists.add(p3);

        for(int i = 0; i < 5; i++){
            for (int j = 0; j < 3; j++) {
                Card card = cardList.remove(0);
                handLists.get(j).add(card);
            }
        }
        return handLists;
    }
    public static void print(List<List<Card>> retLists){
        for (List<Card> list:retLists) {
            for (Card card:list) {
                System.out.print(card);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        List<Card> cardList = new ArrayList<>();
        System.out.println("====生产牌====");
        productCardList(cardList);
        System.out.println(cardList);
        System.out.println("====洗牌====");
        washCardList(cardList);
        System.out.println(cardList);
        System.out.println("====发牌====");
        System.out.println("====三个人每个人五张牌====");
        print(playCardList(cardList));//自定义的二维数组打印方式
    }
}
