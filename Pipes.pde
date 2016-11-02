// grid dimensions
int numBlocks = 8;  // 8 x 8
int blockSize = 100;  // 100 pixels
Cell [][] grid = new Cell[numBlocks][numBlocks];

// Order of these constants is clockwise around cell
int CELLTOP = 0;
int CELLRIGHT = 1;
int CELLBOTTOM = 2;
int CELLLEFT = 3;

void setup() {
  size(800, 800); // numBlocks * blockSize
  for (int x = 0; x < numBlocks; x++)
  {
    for (int y = 0; y < numBlocks; y++)
    {
      int p1 = (int) random(4);
      int p2 = (int) random(4);
      while (p1 == p2)  // Make sure ports are on different sides
        p2 = (int) random(4);

      grid[x][y] = new Cell(blockSize/2+x*blockSize, blockSize/2+y*blockSize, p1, p2);
    }
  }
}

//===========================================================

void draw() {
  background(200);
  drawGrid();
}

void mouseClicked()
{
  int x = mouseX/blockSize;
  int y = mouseY/blockSize;
  grid[x][y].rotate();
}

void keyPressed()
{
}


// Draws a rectangular grid on the screen
void drawGrid()
{
  for (int x = 0; x < numBlocks; x++)
  {
    for (int y = 0; y < numBlocks; y++)
    {
      grid[x][y].draw();
    }
  }
}

//============================================================

class Cell
{
  int port1, port2;
  float myX, myY;

  Cell(float x, float y, int p1, int p2)
  {
    port1 = p1;
    port2 = p2;
    myX = x;
    myY = y;
  }

  void draw()
  {
    noFill();  // Only the outline of each rectangle
    stroke(0); // black outline
    rectMode(CENTER);
    strokeWeight(1);
    rect(myX, myY, blockSize, blockSize);
    drawPort(port1);
    drawPort(port2);
  }

  void rotate()
  {
    // moves each port to next position.
    // if port = 3  --> 3+1 = 4 --> 4%4 = 0
    port1 = (port1+1)%4;
    port2 = (port2+1)%4;
  }

  void drawPort(int p)
  {
    float px, py;
    if (p == CELLBOTTOM || p == CELLTOP)
      px = myX;
    else if (p == CELLRIGHT)
      px = myX - blockSize/2;
    else
      px = myX + blockSize/2;

    if (p == CELLLEFT || p == CELLRIGHT)
      py = myY;
    else if (p == CELLTOP)
      py = myY - blockSize/2;
    else
      py = myY + blockSize/2;

    // draw line from center to port position on edge
    strokeWeight(5);
    line(myX, myY, px, py);
  }
}