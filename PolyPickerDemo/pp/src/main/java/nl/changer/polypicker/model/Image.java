package nl.changer.polypicker.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gil on 04/03/2014.
 */
public class Image implements Parcelable {

    public Uri mUri;
    public int mOrientation;
    public String mDCIMPhotoName;

    public Image(Uri uri, int orientation, String dcimPhotoName) {
        mUri = uri;
        mOrientation = orientation;
        mDCIMPhotoName = dcimPhotoName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mUri, 0);
        dest.writeInt(this.mOrientation);
        dest.writeString(this.mDCIMPhotoName);
    }

    private Image(Parcel in) {
        this.mUri = in.readParcelable(Uri.class.getClassLoader());
        this.mOrientation = in.readInt();
        this.mDCIMPhotoName = in.readString();
    }

    public static final Parcelable.Creator<Image> CREATOR = new Parcelable.Creator<Image>() {
        public Image createFromParcel(Parcel source) {
            return new Image(source);
        }

        public Image[] newArray(int size) {
            return new Image[size];
        }
    };
}
