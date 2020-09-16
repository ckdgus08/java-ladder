package nextstep.ladder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String users = scanner.nextLine();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = Integer.parseInt(scanner.nextLine());

        String[] userArr = users.split(",");
        Ladder ladder = Ladder.of(userArr.length, height);

        System.out.println("실행 결과");

        ResultView resultView = ResultView.of(userArr, ladder);
        resultView.printResult();
    }
}