package com.dct.survey.taishans.utils.PictureSelector.observable;


import com.dct.survey.taishans.utils.PictureSelector.entity.LocalMedia;
import com.dct.survey.taishans.utils.PictureSelector.entity.LocalMediaFolder;

import java.util.List;

/**
 * author：luck
 * project：PictureSelector
 * package：com.luck.picture.lib.observable
 * email：893855882@qq.com
 * data：17/1/16
 */
public interface ObserverListener {
    void observerUpFoldersData(List<LocalMediaFolder> folders);

    void observerUpSelectsData(List<LocalMedia> selectMedias);
}
