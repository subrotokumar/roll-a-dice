package com.subrotokumar.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.subrotokumar.diceroller.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    protected void onCreate(Bundle savedInstanceState) {
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(binding.getRoot());

        Random random=new Random();
        binding.btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int face= random.nextInt(6)+1;
                animate();
                final Handler handler=new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.tvResult.setText(String.valueOf(face));
                        switch(face){
                            case 1:
                                binding.ivDice.setImageResource(R.drawable.dice_icon_1);
                                break;
                            case 2:
                                binding.ivDice.setImageResource(R.drawable.dice_icon_2);
                                break;
                            case 3:
                                binding.ivDice.setImageResource(R.drawable.dice_icon_3);
                                break;
                            case 4:
                                binding.ivDice.setImageResource(R.drawable.dice_icon_4);
                                break;
                            case 5:
                                binding.ivDice.setImageResource(R.drawable.dice_icon_5);
                                break;
                            case 6:
                                binding.ivDice.setImageResource(R.drawable.dice_icon_6);
                                break;
                        }
                    }
                },1000);
            }
        });
    }
    public void animate() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(binding.ivDice, "rotation", 0f, 360f);
        animator.setDuration(1000);
        AnimatorSet animatorSet=new AnimatorSet();
        animatorSet.play(animator);
        animatorSet.start();
    }
}