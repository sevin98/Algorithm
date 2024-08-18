import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        
        for(int i = 0 ; i < 4; i++){
            key = rotate(key);
            //열쇠의 시작 위치를 자물쇠의 바깥쪽부터 해야해서 -m 으로 시작
            for(int r = -m+1; r<n ; r++){
                for(int c = -m+1 ; c<n; c++){
                    if(check(key,lock, r, c))
                        return true;
                }
            }
        }
        return false;
    }//solution
    
    //열쇠 90도 회전 함수
    private static int[][] rotate(int[][] key){
        int M = key.length;
        int[][] rotatedKey = new int[M][M];
        for(int r = 0 ; r < M; r++){
            for(int c = 0 ; c < M; c++){
                rotatedKey[c][M-1-r] = key[r][c];
            }
        }
        return rotatedKey;
    }//rotate
    
    private static boolean check(int[][] key, int[][] lock, int r, int c){
        
        int n = lock.length;
        int m = key.length;
        //열쇠가 밖으로 나가는 것 고려한 크기로 계산해야함
        int[][] bigLock = new int[n+2*(m-1)][n+2*(m-1)];
        
        //확장된 자물쇠에 원래 자물쇠 복사
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n; j++){
                bigLock[i+m-1][j+m-1] = lock[i][j];
            }
        }
        
        //열쇠랑 좌물쇠 비교
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < m; j++){
               int extraR = i + r + m -1;
                int extraC = j + c + m -1;
                if(extraR >= 0 && extraR < n+2*(m-1) && extraC >= 0 && extraC < n+2*(m-1))
                     bigLock[extraR][extraC] += key[i][j];
            }
        }
        
        //열쇠 값 확인
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n ; j++){
                if(bigLock[i+m-1][j+m-1] != 1)
                    return false;
            }
        }
        return true;
    }
    
}