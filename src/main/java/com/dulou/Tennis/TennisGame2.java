package com.dulou.Tennis;

public class TennisGame2 implements TennisGame
{
    public int p1Point = 0;
    public int p2Point = 0;
    
    public String p1Res = "";
    public String p2Res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";

        if (p1Point == p2Point)
        {
            if (p1Point < 3) {
                score = getResScore(p1Point) + "-All";
            }
            else {
                score = "Deuce";
            }
        }
        p1Res = getResScore(p1Point);
        p2Res = getResScore(p2Point);

        if ((p1Point>p2Point && p1Point < 4)||(p2Point>p1Point && p2Point < 4))
        {
            score = p1Res + "-" + p2Res;
        }

            if (p1Point > p2Point && p2Point >= 3)
        {
            score = "Advantage player1";
        }
        
        if (p2Point > p1Point && p1Point >= 3)
        {
            score = "Advantage player2";
        }
        
        if (p1Point>=4 && p2Point>=0 && (p1Point-p2Point)>=2)
        {
            score = "Win for player1";
        }
        if (p2Point>=4 && p1Point>=0 && (p2Point-p1Point)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }

    public String getResScore(int score){
        return switch (score) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "";
        };
    }
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        p1Point++;
    }
    
    public void P2Score(){
        p2Point++;
    }

    public void wonPoint(String player) {
        if (player != null && player.equals("player1"))
            P1Score();
        else
            P2Score();
    }
}