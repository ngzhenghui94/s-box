import java.lang.Integer;
// S-Box
// 48 bits => 32 bits (8*6 => 8*4)
// 2 bits used to select amongst 4 subsitutions for the rest of the 4 bits.
// e.g 1 0 1 1 1 0
// Index 0 and 5 = rows
// Index 1,2,3,4 = columns
// Output = 4 bits
// the first and last bit is 1, 0 which is the binary representation of integer 2
// the remaining bits 0111 which is the binary representation of integer 7
// Therefore the output is at row 2, colum 7 which is 11.
// 11 in binary 1011.


public class sBox {
    static int[][] S_BOX = {
        { 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7 },
        { 0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8 },
        { 4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0 },
        { 15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 }
    };

    public static void main(String[] args) {
        int getDec = Integer.parseInt(args[0]);
        if (getDec < 32){
            String row = "";
            int getRow;
            String column = "";
            int getColumn;
            String decBinary = Integer.toBinaryString(getDec);
            char[] binaryArray = decBinary.toCharArray();
            row = row + binaryArray[0];
            row = row + binaryArray[5];
            column = column + binaryArray[1];
            column = column + binaryArray[2];
            column = column + binaryArray[3];
            column = column + binaryArray[4];
            getRow = Integer.parseInt(row, 2);
            getColumn = Integer.parseInt(column, 2);
            int sBoxDec = S_BOX[getRow][getColumn];
            String sBoxString = Integer.toBinaryString(sBoxDec);
            System.out.println("----");
            System.out.println("Integer: " + getDec);
            System.out.println("Binary: " + decBinary);
            System.out.println("Row: " + row + " Binary representation: " + getRow);
            System.out.println("Column: " + column + " Binary representation: " + getColumn);
            System.out.println("Table lookup found corresponding: " + sBoxDec);
            System.out.println("----");
            System.out.println("The input of S-Box1 in binary: " +  decBinary);
            System.out.println("The output of S-Box1 in binary: " +  sBoxString);
            System.out.println("The output of S-Box1 in decimal: " +  sBoxDec);
        }else{
            System.out.println("Minimum 32 bit required");
        }

    }
}
