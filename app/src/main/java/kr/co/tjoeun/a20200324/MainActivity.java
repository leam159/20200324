package kr.co.tjoeun.a20200324;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import kr.co.tjoeun.a20200324.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {
int[] makeWinLottoNumArr = new  int[6];
int bonusNum =0;
    ActivityMainBinding binding = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
    binding.buyOneLottoBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            당첨번호 생성=>텍스트뷰에 반영
            makeWinLottoNum();

        }
    });
    }

    @Override
    public void setValues() {




    }
    //            6개의 숫자(배열)+보너스 번호1개int변수
//        =>이함수에서만이 아니라,다른곳에서도 쓸 예정
//        =>당첨등수 혹안떄도 사용=>맴버변수
    //당첨번호+보너스번호를 모두0으로 초기화
    //이미뽑은번호있다면 모두날리자
    void makeWinLottoNum(){
        for (int i =0;i<makeWinLottoNumArr.length;i++){
            makeWinLottoNumArr[i]=0;
        }
        bonusNum =0;
//        6개생성
//        1~45여야함 중복x
        for (int i =0; i<makeWinLottoNumArr.length;i++){
//            1~45의 숫자를 랜덤으로 뽑고
//            중복이아니면 당첨번호로 선정
//            중복이라면 다시 뽑자=>중복이 아닐때까지 계속 뽑자
            while (true){
//                1<=(int)(Math.random()*45+1)<46
//                이숫자가 중복검사를 통과하면 사용 아님 다시
                int randomNum =(int)(Math.random()*45+1);
//                중복검사? 당첨번호 정부와ramdom놈을 비교
//                하나라도 같으면 탈락.
               boolean isDuplOk =true;//중복검사
                for (int winNum:makeWinLottoNumArr){
                    if (winNum==randomNum){
                        isDuplOk =false;//탈락
                        break;
                    }
                }
                if (isDuplOk){
                    makeWinLottoNumArr[i]=randomNum;
                    Log.i("당첨번호",randomNum+"");
                    break;//무한반복 탈출
                }
            }

        }
    }
}
