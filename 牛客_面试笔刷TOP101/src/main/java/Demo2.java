public class Demo2 {
    public static void main(String[] args) {
        int[][] originalImage = {
                {128, 64, 32, 16},
                {64, 128, 16, 32},
                {32, 16, 128, 64},
                {16, 32, 64, 128}
        };

        int[][] resizedImage = resizeImage(originalImage, 2);
        printImage(resizedImage);
    }

    public static int[][] resizeImage(int[][] originalImage, int scaleFactor)  {
        int originalRows = originalImage.length;
        int originalCols = originalImage[0].length;

        int resizedRows = originalRows / scaleFactor;
        int resizedCols = originalCols / scaleFactor;

        int[][] resizedImage = new int[resizedRows][resizedCols];

        for (int i = 0; i < resizedRows; i++) {
            for (int j = 0; j < resizedCols; j++) {
                int sum = 0;

                for (int k = 0; k < scaleFactor; k++) {
                    for (int l = 0; l < scaleFactor; l++) {
                        sum += originalImage[i * scaleFactor + k][j * scaleFactor + l];
                    }
                }

                resizedImage[i][j] = sum / (scaleFactor * scaleFactor);
            }
        }

        return resizedImage;
    }

    public static void printImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}
