package com.example.meterialdesign;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class FloatingActionButtonAct extends BaseAct implements View.OnClickListener {
    private CheckBox cbDelay;
    private FloatingActionButton fab01Add;
    private boolean isAdd = false;
    private RelativeLayout rlAddBill;
    private int[] llId = new int[]{R.id.ll01, R.id.ll02, R.id.ll03, R.id.ll04, R.id.ll05, R.id.ll06};
    private LinearLayout[] ll = new LinearLayout[llId.length];
    private int[] fabId = new int[]{R.id.miniFab01, R.id.miniFab02, R.id.miniFab03, R.id.miniFab04, R.id.miniFab05, R.id.miniFab06};
    private FloatingActionButton[] fab = new FloatingActionButton[fabId.length];
    private AnimatorSet addBillTranslate1;
    private AnimatorSet addBillTranslate2;
    private AnimatorSet addBillTranslate3;
    private AnimatorSet addBillTranslate4;
    private AnimatorSet addBillTranslate5;
    private AnimatorSet addBillTranslate6;
    private CoordinatorLayout mView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_flaot_action);
        mView = findViewById(R.id.cl_container);
        initView();
        setDefaultValues();
        bindEvents();
    }

    private void initView() {
        cbDelay = (CheckBox) findViewById(R.id.cbDelay);
        fab01Add = (FloatingActionButton) findViewById(R.id.fab01Add);
        rlAddBill = (RelativeLayout) findViewById(R.id.rlAddBill);
        for (int i = 0; i < llId.length; i++) {
            ll[i] = (LinearLayout) findViewById(llId[i]);
        }
        for (int i = 0; i < fabId.length; i++) {
            fab[i] = (FloatingActionButton) findViewById(fabId[i]);
        }
    }

    private void setDefaultValues() {
        addBillTranslate1 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.add_bill_anim);
        addBillTranslate2 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.add_bill_anim);
        addBillTranslate3 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.add_bill_anim);
        addBillTranslate4 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.add_bill_anim);
        addBillTranslate5 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.add_bill_anim);
        addBillTranslate6 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.add_bill_anim);
    }

    private void bindEvents() {
        fab01Add.setOnClickListener(this);
        for (int i = 0; i < fabId.length; i++) {
            fab[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab01Add:
                fab01Add.setImageResource(isAdd ? R.mipmap.ic_add : R.mipmap.ic_close);
                isAdd = !isAdd;
                rlAddBill.setVisibility(isAdd ? View.VISIBLE : View.GONE);
                if (isAdd) {
                    addBillTranslate1.setTarget(ll[0]);
                    addBillTranslate1.start();
                    addBillTranslate2.setTarget(ll[1]);
                    addBillTranslate2.setStartDelay(cbDelay.isChecked() ? 150 : 0);
                    addBillTranslate2.start();
                    addBillTranslate3.setTarget(ll[2]);
                    addBillTranslate3.setStartDelay(cbDelay.isChecked() ? 200 : 0);
                    addBillTranslate3.start();
                    addBillTranslate4.setTarget(ll[3]);
                    addBillTranslate4.setStartDelay(cbDelay.isChecked() ? 250 : 0);
                    addBillTranslate4.start();
                    addBillTranslate5.setTarget(ll[4]);
                    addBillTranslate5.setStartDelay(cbDelay.isChecked() ? 300 : 0);
                    addBillTranslate5.start();
                    addBillTranslate6.setTarget(ll[5]);
                    addBillTranslate6.setStartDelay(cbDelay.isChecked() ? 350 : 0);
                    addBillTranslate6.start();
                }
                break;
            case R.id.miniFab01:
                hideFABMenu();
                break;
            case R.id.miniFab02:
                hideFABMenu();
                break;
            case R.id.miniFab03:
                hideFABMenu();
                break;
            case R.id.miniFab04:
                hideFABMenu();
                break;
            case R.id.miniFab05:
                hideFABMenu();
                //View view = LayoutInflater.from(FloatingActionButtonAct.this).inflate(R.layout.layout_snackbar, null);
                Snackbar.make(mView, "已删除一个会话", Snackbar.LENGTH_LONG)
                        .setAction("撤销", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.d("hql", "点击view");
                            }
                        })
                        .setAction("撤销2", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("hql", "点击view2");
                    }
                })
                        .show();
                break;
            case R.id.miniFab06:
                hideFABMenu();
                break;
            default:
                break;
        }
    }

    private void hideFABMenu() {
        rlAddBill.setVisibility(View.GONE);
        fab01Add.setImageResource(R.mipmap.ic_add);
        isAdd = false;
    }
}