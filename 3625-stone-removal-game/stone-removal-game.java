class Solution {
    public boolean canAliceWin(int n) {
        if(n<10) return false;
        else if(n>=10 && n<=18) return true;
        else if(n>=19 && n<=26) return false;
        else if(n>=27 && n<=33) return true;
        else if(n>=34 && n<=39) return false;
        else if(n>=40 && n<=44) return true;
        else if(n>=45 && n<=48) return false;
        else return true;
        
    }
}