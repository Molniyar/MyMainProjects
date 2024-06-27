public class ArrayChange {
    public static Object[] removeObject(Object[] arr){
        return null;
    }
    public static boolean isEmpty(Object[] arr){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != null){
                return false;
            }
        }
        return true;
    }
    public static boolean numbersAreEquals(int[] arr, int num){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != num){
                return false;
            }
        }
        return true;
    }
    public static boolean isGridEmpty(Object[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if (arr[i][j] != null){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isGridEmpty(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if (arr[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
    }
}
