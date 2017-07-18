package com.dct.survey.taishans.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dct.survey.taishans.R;
import com.dct.survey.taishans.bean.DictionaryBean;

import java.util.List;


/**
 * 创建：Android
 * 日期：2017/7/12 17:03
 * 描述：dialogPlus弹窗数据适配器
 */

public class DialogAdapter extends BaseAdapter {

    private List<DictionaryBean> dictionaryBeen;

    public DialogAdapter(List<DictionaryBean> dictionaryBeen) {
        this.dictionaryBeen = dictionaryBeen;
    }

    @Override
    public int getCount() {
        return dictionaryBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return dictionaryBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (null == convertView){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dialog_dictionary, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.tvTitle.setText(dictionaryBeen.get(position).getNAME());
        viewHolder.tvContent.setText(dictionaryBeen.get(position).getDESCRIPTION());
        return convertView;
    }

    static class ViewHolder{
        private static TextView tvTitle;
        private static TextView tvContent;
        public ViewHolder(View convertView) {
            tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            tvContent = (TextView) convertView.findViewById(R.id.tv_content);
        }
    }
}
