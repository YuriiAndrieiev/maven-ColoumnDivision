package com.yurii.andrieiev.ua;

import java.util.List;

public class PaintProccessDivision {
    private String paintHead(DivisionResult divisionResult) {
        StringBuilder pictureHead = new StringBuilder();
        int finalResult = divisionResult.getFinalResult();
        int dividend = divisionResult.getDividend();
        List<CurrentResult> results = divisionResult.getCurrentResults();
        CurrentResult currentResult0 = (results.get(0));
        int firstCurrentDividendInt = currentResult0.getCurrentDividendInt();
        int firstNumberSubtracted =  currentResult0.getNumberSubtracted();
        int firstSpaceDiffernce = firstCurrentDividendInt - firstNumberSubtracted;
        pictureHead.append("_").append(dividend).append("|").append(divisionResult.getDivider())
                .append(System.lineSeparator()).append(" ").append(firstNumberSubtracted)
                .append(" ".repeat(Integer.toString(dividend).length() - Integer.toString(firstNumberSubtracted).length()))
                .append("|----").append(System.lineSeparator()).append(" ")
                .append("-".repeat(Integer.toString(firstNumberSubtracted).length()))
                .append(" ".repeat(Integer.toString(dividend).length() - Integer.toString(firstNumberSubtracted).length()))
                .append("|").append(finalResult).append(System.lineSeparator());
        if (results.size() == 1) {
            int firstRemainder = firstCurrentDividendInt - firstNumberSubtracted;
            pictureHead.append(" ".repeat(
                    Integer.toString(firstNumberSubtracted).length() - Integer.toString(firstRemainder).length()));
            pictureHead.append(" " + firstRemainder);
        }
        return new String(pictureHead);
    }

    private String paintBody(DivisionResult divisionResult) {
        StringBuilder pictureBody = new StringBuilder();
        List<CurrentResult> results = divisionResult.getCurrentResults();
        StringBuilder space = new StringBuilder();
        CurrentResult currentResult0 = (results.get(0));
        int firstCurrentDividendInt = currentResult0.getCurrentDividendInt();
        int firstNumberSubtracted = currentResult0.getNumberSubtracted();
        int difference = firstCurrentDividendInt-firstNumberSubtracted;
        int firstSpaceDiffernce = Integer.toString(firstCurrentDividendInt).length() - Integer.toString(firstNumberSubtracted).length();
        if (difference==0) {
            space.append(" ".repeat(Integer.toString(firstCurrentDividendInt).length()));
        }else if (Integer.toString(firstCurrentDividendInt).length()==Integer.toString(firstNumberSubtracted).length()){
            space.append(" ".repeat(0));
        }else {
            space.append(" ".repeat(firstSpaceDiffernce));
        }
        int dividend = divisionResult.getDividend();
        for (int i = 1; i < results.size(); i++) {
            CurrentResult previousElement = (results.get((--i)));
            i++;
            int previousDiffenence = previousElement.getSpaceDifference();
            CurrentResult currentResult = results.get(i);
            CurrentResult element = (results.get(i));
            int currentDividendInt = element.getCurrentDividendInt();
            int numberSubtracted = element.getNumberSubtracted();
            if (numberSubtracted == 0) {
                pictureBody.append(" ".repeat(space.length() + 1));
                pictureBody.append(currentDividendInt);
                break;
            }
            if (currentDividendInt == 0) {
                space.append(" ".repeat(Integer.toString(firstCurrentDividendInt).length()));
            }
            space.append(" ".repeat(previousDiffenence));
            pictureBody.append(space).append("_").append(currentDividendInt).append(System.lineSeparator());
            pictureBody.append(space).append(" ").append(numberSubtracted).append(System.lineSeparator());
            pictureBody.append(space).append(" ").append("-".repeat(Integer.toString(numberSubtracted).length()))
                    .append(System.lineSeparator());
            if (currentDividendInt == numberSubtracted) {
                space.append(" ".repeat(Integer.toString(previousDiffenence).length() + 1));
            }
            if (i == results.size() - 1) {
                int remainder = currentResult.getCurrentDividendInt() - currentResult.getNumberSubtracted();
                pictureBody.append(" ");
                pictureBody.append(" ".repeat(Integer.toString(dividend).length() - Integer.toString(remainder).length()));
                pictureBody.append(remainder);
            }
        }
        String pictureBodyStr = (pictureBody.toString());
        return new String(pictureBodyStr);
    }

    public String paintFullPicture(DivisionResult divisionResult) {
        String head = paintHead(divisionResult);
        String body = paintBody(divisionResult);
        return head.concat(body);
    }
}
