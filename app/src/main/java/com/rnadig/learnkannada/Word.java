package com.rnadig.learnkannada;

/**
 * Created by  on 09-Jul-16.
 */
public class Word {
    private String mKannada;

    private String mEnglish;
    private int mAudioId;

    private static final int NO_IMAGE = -1;
    private int mImageId = NO_IMAGE;

    public Word(String englishTranslation, String kannadaTranslation, int imageId, int audioId) {
        mKannada = kannadaTranslation;
        mEnglish = englishTranslation;
        mImageId = imageId;
        mAudioId = audioId;
    }

    public Word(String englishTranslation, String kannadaTranslation, int audioId) {
        mKannada = kannadaTranslation;
        mEnglish = englishTranslation;
        mAudioId = audioId;

    }

    public String getKannada() {
        return mKannada;
    }

    public String getEnglish() {
        return mEnglish;
    }

    public int getmImageId() {
        return mImageId;
    }

    public boolean hasImage() {
        return mImageId != NO_IMAGE;
    }

    public int getmAudioId() {
        return mAudioId;
    }
}


