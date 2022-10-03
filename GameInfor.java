package goldrush;

import java.util.Scanner;

import goldrush.Charac.Charac;
import goldrush.Charac.NormalCharac;
import goldrush.Charac.SuperCharac;
import goldrush.Thing.Thing;

public class GameInfor {
    int row, column;
    int numberOfGold, numberOfTrap, goldToWin;
    Thing[][] map;
    int thief;
    Charac charac;

    public void createInfor() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Nhap so hang, so cot");
            this.row = input.nextInt();
            this.column = input.nextInt();
            System.out.println("Nhap so vang, so bay");
            this.numberOfGold = input.nextInt();
            this.numberOfTrap = input.nextInt();
            System.out.println("Nhap so vang de thang");
            this.goldToWin = input.nextInt();
            System.out.println("Nhap 1 de chon nhan vat binh thuong va 2 de chon nhan vat chuyen nghiep");
            this.thief = input.nextInt();
        }
        if (thief == 1) {
            charac = new NormalCharac();
        } else if (thief == 2) {
            charac = new SuperCharac();
        }

        this.map = new Thing[row][column];
    }
}
