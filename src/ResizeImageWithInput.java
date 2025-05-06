//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Scanner;

public class ResizeImageWithInput {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем путь к исходному изображению
        System.out.print("Введите полный путь к исходному изображению: ");
        String inputPath = scanner.nextLine().trim(); // Получаем путь к исходнику

        // Читаем исходное изображение
        File inputFile = new File(inputPath);
        if (!inputFile.exists()) {
            throw new IllegalArgumentException("Файл не существует!");
        }
        BufferedImage originalImage = ImageIO.read(inputFile);

        // Запрашиваем новый размер изображения
        System.out.print("Введите ширину нового изображения: ");
        int width = Integer.parseInt(scanner.nextLine().trim()); // Ширина
        System.out.print("Введите высоту нового изображения: ");
        int height = Integer.parseInt(scanner.nextLine().trim()); // Высота

        // Создаем новое изображение нужного размера
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR); // Улучшаем качество масштабирования
        g2d.drawImage(originalImage, 0, 0, width, height, null);
        g2d.dispose();

        // Запрашиваем путь для сохранения результирующего изображения
        System.out.print("Введите полный путь для сохранения итогового изображения: ");
        String outputPath = scanner.nextLine().trim(); // Путь для выхода

        // Сохраняем новое изображение
        String formatName = "jpg"; // Формат изображения
        File outputFile = new File(outputPath);
        ImageIO.write(resizedImage, formatName, outputFile);

        System.out.println("Изображение успешно изменено и сохранено.");
    }
}