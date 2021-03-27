package libraries;
import java.util.function.UnaryOperator;

public class Bound<T> {
	private UnaryOperator<T> policy;
	private T from;
	private T to;
	
	public T getNext(T current) {
		if(current == null) return from;
		return policy.apply(current);
	}

	public UnaryOperator<T> getPolicy() {
		return policy;
	}

	public void setPolicy(UnaryOperator<T> policy) {
		this.policy = policy;
	}

	public T getFrom() {
		return from;
	}

	public void setFrom(T from) {
		this.from = from;
	}

	public T getTo() {
		return to;
	}

	public void setTo(T to) {
		this.to = to;
	}

	public static class Builder<T> {
		private UnaryOperator<T> policy;
		private T from;
		private T to;
		
		public Builder(T from, T to) {
			this.from = from;
			this.to = to;
		}
		
		public Builder(UnaryOperator<T> policy, T from) {
			this.policy = policy;
			this.from = from;
		}
		
		public Builder<T> withTo(T to) {
			this.to = to;
			return this;
		}
		
		public Bound<T> build() {
			return new Bound<T>(this);
		}
	}
	
	private Bound() {
		super();
	}

	private Bound(Builder<T> builder) {
		this.setPolicy(builder.policy);
		this.setFrom(builder.from);
		this.setTo(builder.to);
	}

	public Bound<T> cloneObject() {
		return new Builder<T>(this.policy, this.from).withTo(this.to).build();
	}

}