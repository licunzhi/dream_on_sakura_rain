package com.sakura.structuralPatterns.AdapterPattern;

import com.sakura.structuralPatterns.AdapterPattern.impl.AudioPlayer;

/**
 * @author licunzhi
 * @desc test demo to take a example
 * @date 2018-08-31
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {

        /**
         * conclusion:
         *      AdapterPattern belong to StructuralPatterns
         *      in fact add the interface function when the utils can not fill the needs
         *
         *      but how we can do
         *      for example we have a base interface that has the base function to play special type music
         *      but now we need to play other type music or video,but it is not supported
         *
         *      one way we can do is to build another class or interface to satisfy the business needs
         *      it is ok, but not recommend
         *      because we may have the interface or class these function, but not in the same class or interface
         *      or the way to deal with the operation is just different
         *
         *      so we can use the utils class as before, but wo can use a wrapper class to wrap others
         *      in the wrapper class, we may build a method a produce other class object
         *      another method to use the class object`s method
         *
         *      by doing like that, we just import the wrapper class and do as the method or give a special
         *      param, then wo can get the object we want or the implements of the function
         *
         *      the benefits of that are some other interface do not change anything
         *      they just keep the same code or logical method
         *      we only need create a new class to build a relation between player and other class
         *      (just like the code we takes for example)
         *
         */
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");

    }
}
