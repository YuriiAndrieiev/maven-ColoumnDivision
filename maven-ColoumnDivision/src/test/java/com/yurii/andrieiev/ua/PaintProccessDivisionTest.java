package com.yurii.andrieiev.ua;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PaintProccessDivisionTest {

    @Test
    public void paintFullPictureShouldReturnOutputWithTheSameCurrentResultsWhenDividendHasNumbersAsDivider(){
        StringBuilder firstPicture = new StringBuilder();
        firstPicture.append("_"+"363636"+"|"+"36"+System.lineSeparator());
        firstPicture.append(" "+"36"+ "    "+ "|----"+System.lineSeparator());
        firstPicture.append(" " + "--"+"    "+"|"+"10101"+System.lineSeparator());
        firstPicture.append("  "+"_"+"36"+System.lineSeparator());
        firstPicture.append("   "+"36"+System.lineSeparator());
        firstPicture.append("   "+"--"+System.lineSeparator());
        firstPicture.append("    "+"_"+"36"+System.lineSeparator());
        firstPicture.append("    "+" "+"36"+System.lineSeparator());
        firstPicture.append("    "+" "+"--"+System.lineSeparator());
        firstPicture.append("      "+"0");
        String firstPictureStr = firstPicture.toString();
        PaintProccessDivision paintProcessDivision = new PaintProccessDivision();
        List<CurrentResult> currentResults = List.of(new CurrentResult(36, 36, 0),
                new CurrentResult(36, 36, 0),
                new CurrentResult(36, 36, 0));;
        DivisionResult divisionResult = new DivisionResult(363636,36,10101,currentResults );
        String end = String.valueOf(paintProcessDivision.paintFullPicture(divisionResult));
        assertEquals(firstPictureStr,paintProcessDivision.paintFullPicture(divisionResult));
    }

    @Test
    public void
    paintFullPictureShouldReturnOutPutWithTwoCurrentResultsAndRemainderWhenDividendConsistsOfThreeFiguresDividerOfTwo() {
        StringBuilder firstPicture = new StringBuilder();
        firstPicture.append("_"+"534"+"|"+"12"+System.lineSeparator());
        firstPicture.append(" "+"48"+ " "+ "|----"+System.lineSeparator());
        firstPicture.append(" " + "--"+" "+"|"+"44"+System.lineSeparator());
        firstPicture.append(" "+"_"+"54"+System.lineSeparator());
        firstPicture.append("  "+"48"+System.lineSeparator());
        firstPicture.append("  "+"--"+System.lineSeparator());
        firstPicture.append("   "+"6");
        String firstPictureStr = firstPicture.toString();
        PaintProccessDivision paintProcessDivision = new PaintProccessDivision();
        List<CurrentResult>currentResults = List.of(new CurrentResult(53, 48, 1),
                new CurrentResult(54,48, 1));;
        DivisionResult divisionResult = new DivisionResult(534,12,44,currentResults );
        String end = String.valueOf(paintProcessDivision.paintFullPicture(divisionResult));
        assertEquals(firstPictureStr,paintProcessDivision.paintFullPicture(divisionResult));
    }

    @Test
    public void
    paintFullPictureShouldReturnOutPutWithTwoTheSameCurrentResultsAndRemovedRemainderWhenLastNumberShortenAsDivider() {
        StringBuilder firstPicture = new StringBuilder();
        firstPicture.append("_"+"88888"+"|"+"88"+System.lineSeparator());
        firstPicture.append(" "+"88"+ "   "+ "|----"+System.lineSeparator());
        firstPicture.append(" " + "--"+"   "+"|"+"88"+System.lineSeparator());
        firstPicture.append("  "+"_"+"88"+System.lineSeparator());
        firstPicture.append("   "+"88"+System.lineSeparator());
        firstPicture.append("   "+"--"+System.lineSeparator());
        firstPicture.append("    "+"8");
        String firstPictureStr = firstPicture.toString();
        PaintProccessDivision paintProcessDivision = new PaintProccessDivision();
        List<CurrentResult>currentResults = List.of(new CurrentResult(88, 88, 0),
                new CurrentResult(88, 88, 0));;
        DivisionResult divisionResult = new DivisionResult(88888,88,1010,currentResults );
        String end = String.valueOf(paintProcessDivision.paintFullPicture(divisionResult));
        assertEquals(firstPictureStr,paintProcessDivision.paintFullPicture(divisionResult));
    }

    @Test
    public void paintFullPictureShouldReturnOutputWithSixCurrentResultsWhenDividendIsMuchLongerThanDivider() {
        StringBuilder firstPicture = new StringBuilder();
        firstPicture.append("_"+"87534363"+"|"+"7"+System.lineSeparator());
        firstPicture.append(" "+"7"+ "       "+ "|----"+System.lineSeparator());
        firstPicture.append(" " + "-"+"       "+"|"+"12504909"+System.lineSeparator());
        firstPicture.append(""+"_"+"17"+System.lineSeparator());
        firstPicture.append(" "+"14"+System.lineSeparator());
        firstPicture.append(" "+"--"+System.lineSeparator());
        firstPicture.append(" "+"_"+"35"+System.lineSeparator());
        firstPicture.append(" "+" "+"35"+System.lineSeparator());
        firstPicture.append(" "+" "+"--"+System.lineSeparator());
        firstPicture.append("   "+"_"+"34"+System.lineSeparator());
        firstPicture.append("   "+" "+"28"+System.lineSeparator());
        firstPicture.append("   "+" "+"--"+System.lineSeparator());
        firstPicture.append("    "+"_"+"63"+System.lineSeparator());
        firstPicture.append("    "+" "+"63"+System.lineSeparator());
        firstPicture.append("    "+" "+"--"+System.lineSeparator());
        firstPicture.append("      "+"_"+"64"+System.lineSeparator());
        firstPicture.append("      "+" "+"63"+System.lineSeparator());
        firstPicture.append("      "+" "+"--"+System.lineSeparator());
        firstPicture.append("      "+"  "+"1");
        String firstPictureStr = firstPicture.toString();
        PaintProccessDivision paintProcessDivision = new PaintProccessDivision();
        List<CurrentResult>currentResults = List.of(new CurrentResult(8, 7, 0),
                new CurrentResult(17, 14, 1),
                new CurrentResult(35, 35, 0),
                new CurrentResult(34, 28, 1),
                new CurrentResult(63, 63, 0),
                new CurrentResult(64, 63, 1));
        DivisionResult divisionResult = new DivisionResult(87534363,7,12504909,currentResults );
        String end = String.valueOf(paintProcessDivision.paintFullPicture(divisionResult));
        assertEquals(firstPictureStr,paintProcessDivision.paintFullPicture(divisionResult));
    }

    @Test
    public void paintFullPictureReturnOutputWithFourCurrentResultsWhenDividendIsLongerAThreeFiguresThanDividend() {
        StringBuilder firstPicture = new StringBuilder();
        firstPicture.append("_"+"36281"+"|"+"21"+System.lineSeparator());
        firstPicture.append(" "+"21"+ "   "+ "|----"+System.lineSeparator());
        firstPicture.append(" " + "--"+"   "+"|"+"1727"+System.lineSeparator());
        firstPicture.append("  "+"_"+"152"+System.lineSeparator());
        firstPicture.append("   "+"147"+System.lineSeparator());
        firstPicture.append("   "+"--"+System.lineSeparator());
        firstPicture.append("     "+"_"+"58"+System.lineSeparator());
        firstPicture.append("     "+" "+"42"+System.lineSeparator());
        firstPicture.append("     "+" "+"--"+System.lineSeparator());
        firstPicture.append("     "+"_"+"161"+System.lineSeparator());
        firstPicture.append("     "+" "+"147"+System.lineSeparator());
        firstPicture.append("     "+" "+"---"+System.lineSeparator());
        firstPicture.append("   "+"14");
        String firstPictureStr = firstPicture.toString();
        PaintProccessDivision paintProcessDivision = new PaintProccessDivision();
        List<CurrentResult>currentResults = List.of(new CurrentResult(36, 21, 0),
                new CurrentResult(152, 147, 2),
                new CurrentResult(58, 42, 0),
                new CurrentResult(161, 147, 1));
        DivisionResult divisionResult = new DivisionResult(36281,21,1727,currentResults );
        String end = String.valueOf(paintProcessDivision.paintFullPicture(divisionResult));
        assertEquals(firstPictureStr,paintProcessDivision.paintFullPicture(divisionResult));
    }
}
