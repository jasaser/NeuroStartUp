import java.util.Scanner;

public class Main {

    public static int usnIncomeMinusTax(int income) {
        int taxSimple = (income * 6 / 100);
        return taxSimple;
    }

    public static int usnIncomeMinusOutgo(int income, int outgo) {
        int tax = ((income - outgo) * 15 / 100);
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }


    public static void main(String[] args) {

        int income = 0;
        int outgo = 0;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n" +
                    "Введите номер операции и нажмите <Enter>\n" +
                    "1. Добавить новый доход\n" +
                    "2. Добавить новый расход\n" +
                    "3. Выбрать систему налогообложения\n" +
                    "Для завершения программы введите end\n");

            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }

            int choiceOfUser = Integer.parseInt(input);
            switch (choiceOfUser) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    income += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расходов:");
                    String moneyStrMinus = scanner.nextLine();
                    int moneySpending = Integer.parseInt(moneyStrMinus);
                    outgo += moneySpending;
                    break;
                case 3:

                    if (usnIncomeMinusTax(income) < usnIncomeMinusOutgo(income, outgo)) {
                        System.out.println("Выгодная УСН 6% от доходов");
                        System.out.println("Ваш налог составит " + usnIncomeMinusTax(income) + "\n" +
                                "Налог на другой системе составит " + usnIncomeMinusOutgo(income, outgo) + "\n");
                        System.out.println("Ваша экономия: " + (usnIncomeMinusOutgo(income, outgo) - usnIncomeMinusTax(outgo)));


                    } else if (usnIncomeMinusTax(income) > usnIncomeMinusOutgo(income, outgo)) {
                        System.out.println("Выгодная УСН налог 15% от разницы доходов и расходов");
                        System.out.println("Ваш налог составит " + usnIncomeMinusOutgo(income, outgo) + "\n" +
                                "Налог на другой системе составит " + usnIncomeMinusTax(income) + "\n");
                        System.out.println("Ваша экономия: " + (usnIncomeMinusTax(income) - usnIncomeMinusOutgo(income, outgo)));

                    } else if (usnIncomeMinusTax(income) == usnIncomeMinusOutgo(income, outgo)) {
                        System.out.println("Налог равен или Вы не ввели доход/расход");
                    }
                    break;
                default:
                    System.out.println("Нет такого варианта!");
            }


        }


    }


}





