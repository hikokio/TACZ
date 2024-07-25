package com.tacz.guns.resource.pojo.data.attachment;

import com.google.common.collect.Maps;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tacz.guns.api.modifier.JsonProperty;

import javax.annotation.Nullable;
import java.util.Map;

public class AttachmentData {
    @Expose(serialize = false, deserialize = false)
    private Map<String, JsonProperty<?, ?>> modifier = Maps.newHashMap();

    @SerializedName("silence")
    @Nullable
    private Silence silence;

    @SerializedName("weight")
    private float weight = 0;

    @SerializedName("ads_addend")
    @Deprecated
    private float adsAddendTime = 0;

    @SerializedName("ads")
    @Nullable
    private ModifiedValue ads = null;

    @SerializedName("extended_mag_level")
    private int extendedMagLevel = 0;

    @SerializedName("inaccuracy_addend")
    private float inaccuracyAddend = 0;

    @SerializedName("recoil_modifier")
    @Nullable
    private RecoilModifier recoilModifier = null;

    @SerializedName("melee")
    @Nullable
    private MeleeData meleeData = null;

    @Nullable
    public Silence getSilence() {
        return silence;
    }

    public float getWeight() {
        return weight;
    }

    public int getExtendedMagLevel() {
        return extendedMagLevel;
    }

    @Deprecated
    public float getAdsAddendTime() {
        return adsAddendTime;
    }

    @Nullable
    public ModifiedValue getAds() {
        return ads;
    }

    public float getInaccuracyAddend() {
        return inaccuracyAddend;
    }

    @Nullable
    public RecoilModifier getRecoilModifier() {
        return recoilModifier;
    }

    @Nullable
    public MeleeData getMeleeData() {
        return meleeData;
    }

    public void addModifier(String id, JsonProperty<?, ?> jsonProperty) {
        modifier.put(id, jsonProperty);
    }

    public Map<String, JsonProperty<?, ?>> getModifier() {
        return modifier;
    }
}
