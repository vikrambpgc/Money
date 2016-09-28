
/*
import processing.video.*;

PImage img;
Capture cam;

void setup() {
  size(320, 240);
  
  cam = new Capture(this, 320, 240, 24);
  cam.start();
}

void draw() {
    PImage edgeImg;
    
    image(cam, 0, 0);
    img = get();
  
    //For blur
    edgeImg = blur(img);
    edgeImg.updatePixels();     // State that there are changes to edgeImg.pixels[]
	image(edgeImg, width/2, 0); // Draw the new image from point (width/2,0)
	
	//For vertical Sobel
    //edgeImg = verticalSobel(img);
    //edgeImg.updatePixels();
	//image(edgeImg, width/2, 0);
	
}

PImage blur(PImage img) {
    
    //Modify this matrix as per your required filter.
    float v = 1.0/25.0;
    float[][]	bkernel	=	{	
		{ v,	v,	v,	v,	v},
		{ v,	v,	v,	v,	v},
		{ v,	v,	v,	v,	v},
		{ v,	v,	v,	v,	v},
		{ v,	v,	v,	v,	v},
    };
    
    //Apply all the operations on the bkernel before 
    //assigning to final matrix 'kernel' that is used
    //for multiplication in 'applyFilter' method'.
    
    float[][] kernel = bkernel;
    
    //Return the PImage returned by applyFilter.
    return applyFilter(kernel, img);
}

PImage verticalSobel(PImage img) {
    float[][] SobelY = {
		{-1,-2, -1},
		{0,	0,	0},
		{1,	2,	1}
    };
    
    //Apply all the operations on the bkernel before 
    //assigning to final matrix 'kernel' that is used
    //for multiplication in 'applyFilter' method'.
    
    float[][] kernel = SobelY;
    
    //Return the PImage returned by applyFilter.
    return applyFilter(kernel, img);
}

PImage horizontalSobel(PImage img) {
    float[][] SobelX = {
		{-1,0, 1},
		{-2,0, 2},
		{-1,0, 1}
    };
    
    //Apply all the operations on the bkernel before 
    //assigning to final matrix 'kernel' that is used
    //for multiplication in 'applyFilter' method'.
    
    float[][] kernel = SobelX;
    
    //Return the PImage returned by applyFilter.
    return applyFilter(kernel, img);
}

PImage Sobel(PImage img) {
    PImage hSobel, vSobel;
    int pos = 0, 
    float hColor=0, vColor = 0, mag = 0;

    //Create an opaque image of the same size as the original
    PImage edgeImg = createImage(img.width, img.height, RGB);
    
    hSobel = verticalSobel(img);
    hSobel.updatePixels();
    vSobel = horizontalSobel(img);
    vSobel.updatePixels();
    
    for (int y = 0; y < img.height; y++) { 
        for (int x = 0; x < img.width; x++) {
        
            pos = y*img.width + x;
            
            hColor = green(hSobel.pixels[pos]);
            vColor = green(vSobel.pixels[pos]);
            
            mag	= (int)Math.sqrt(Math.pow(hColor,2) +	Math.pow(vColor,2));
            
            edgeImg.pixels[pos] = color(mag);
        }
    }
    edgeImg.updatePixels();
  
    return edgeImg;
}


PImage TwoDfilter(PImage img) {
    float v = 1.0/25.0;
    float[][] firstFilter = {
        {v},
        {v},
        {v},
        {v},
        {v},
    };
    
    float[][] secondFilter = {
        {1, 1, 1, 1, 1}
    };
    
    //Create an opaque image of the same size as the original
    PImage edgeImg = createImage(img.width, img.height, RGB);
    
    edgeImg = applyFilter(firstFilter, img);
    edgeImg.updatePixels();
    
    edgeImg = applyFilter(secondFilter, edgeImg);
    edgeImg.updatePixels();
    
    return edgeImg;
    
}

//Applies the kernel filter on the input 'img'.
//Kernel filter can be of any dimensional matrix.
//Just make sure that the kernel matrix is the final matrix
//which resulted after normalization/manipulation etc.
//Kernel matrix is the final matrix which u want to multiply
//with each pixel of source 'img'.

PImage applyFilter(float[][] kernel, PImage img) {
  image(img, 0, 0); // Displays the image from point (0,0)
  img.loadPixels();
  
  // Create an opaque image of the same size as the original
  PImage edgeImg = createImage(img.width, img.height, RGB);
	  
  for (int y = 0; y < img.height; y++) { 
    for (int x = 0; x < img.width; x++) {

      float s = 0;
      for (int kj = 0; kj < kernel.length; kj++) {
        for (int ki = 0; ki < kernel[kj].length; ki++) {
          // Calculate the pixel position for kernel entry (kj,ki)
          int ky = ki - kernel.length/2;
          int kx = kj - kernel[kj].length/2;
          int yy = y + ky;
          int xx = x + kx;     
          // find (xx,yy) position in the pixel aray    
          int pos = yy*img.width + xx;
          // make sure the pixel position is valid
          if (yy >= 0 && yy < img.height && xx >= 0 && xx < img.width) {
            // assumes image is grayscale (r = g = b)
            s += kernel[kj][ki] * green(img.pixels[pos]);
          }
        }
      }
      edgeImg.pixels[y*img.width + x] = color(s);
    }
  }
  edgeImg.updatePixels();
  
  return edgeImg;
}

// for video capture
void captureEvent(Capture c) {
  c.read();
  c.filter(GRAY);
}
*/