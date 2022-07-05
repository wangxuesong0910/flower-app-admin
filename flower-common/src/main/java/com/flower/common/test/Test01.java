package com.flower.common.test;

import cn.hutool.core.codec.Base62;
import com.flower.common.utils.uuid.IdUtils;
import com.flower.common.utils.uuid.UUID;
import org.junit.Rule;
import org.junit.Test;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Test01 {

    @Test
    public void test() throws Exception{
        //Create the barcode bean
        Code128Bean bean = new Code128Bean();

        final int dpi = 150;

//Configure the barcode generator
        bean.setModuleWidth(UnitConv.in2mm(1.0f / dpi)); //makes the narrow bar
        //width exactly one pixel
//        bean.setWideFactor(3);
        bean.doQuietZone(false);

//Open output file
        File outputFile = new File("out.png");
        OutputStream out = new FileOutputStream(outputFile);
        try {
            //Set up the canvas provider for monochrome PNG output
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                    out, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);

            String s1 = IdUtils.fastSimpleUUID();

            //Generate the barcode
            bean.generateBarcode(canvas, "a23a82x6b");

            //Signal end of generation
            canvas.finish();
        } finally {
            out.close();
        }
    }

    @Test
    public void test02(){

    }
}
