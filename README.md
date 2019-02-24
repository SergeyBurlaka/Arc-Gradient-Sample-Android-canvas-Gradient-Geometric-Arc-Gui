# Arc-Gradient-Sample-Android-canvas-Gradient-Geometric-Arc-Gui


![](https://github.com/SergeyBurlaka/Arc-Gradient-Sample-Android-canvas-Gradient-Geometric-Arc-Gui/blob/master/app/src/art/Screenshot_1551012440.png)

How does Sweep Gradient works?
If you draw rect via this:

  
```kotlin
         private val colors = intArrayOf(ContextCompat.getColor(context, R.color.progress_from_color),
     ContextCompat.getColor(context, R.color.progress_to_color))
    
        private var positions = floatArrayOf(0.0f, 1.0f)
        private var sweepGradient : SweepGradient? = null
        
        sweepGradient = SweepGradient(w / 2F,h / 2F,colors,  positions)
        
```

It will be: 

[![enter image description here][1]][1]

So the idea is to rotate graient!
```kotlin
     sweepGradient.apply {
                val rotate = 270f
                val gradientMatrix = Matrix()
                gradientMatrix.preRotate(rotate, mWidth / 2F, mHeight / 2F)
                setLocalMatrix(gradientMatrix)
            }
```            
[![][2]][2]

Finally we can draw our arc:

```kotlin
     mPaint.shader = gradient
     canvas.drawArc(rectF, startAngle, finishedSweepAngle, false, mPaint)

```    
[![][3]][3]



 


  [1]: https://i.stack.imgur.com/EFxAq.jpg
  [2]: https://i.stack.imgur.com/UKOlp.jpg
  [3]: https://i.stack.imgur.com/EXa6Y.jpg

