import java.util.*;

class AsciiCharSequence implements CharSequence {
    byte[] sequence;

    public AsciiCharSequence(byte[] sequence) {
        this.sequence = Arrays.copyOf(sequence, sequence.length);
    }

    @Override
    public int length() {
        return this.sequence.length;
    }

    @Override
    public char charAt(int i) {
        for (int i1 = 0; i1 < this.sequence.length; i1++) {
            if (i == i1) {
                return (char) this.sequence[i];
            }
        }
        return (char) this.sequence[0];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        byte[] bytes = Arrays.copyOfRange(this.sequence, i, i1);
        return new AsciiCharSequence(bytes);
    }

    @Override
    public String toString() {
        return new String(this.sequence);
    }
}