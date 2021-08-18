package cdm.base.math;

import cdm.base.math.meta.VectorMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A list of numbers to be processed as a unit.  It can contain 0 or more numbers.   It is passwed into and out of library functions to avoid Rosetta limitations with code generation for built-in types
 * @version ${project.version}
 */
@RosettaClass

public interface Vector extends RosettaModelObject {
	Vector build();
	Vector.VectorBuilder toBuilder();
	
	/**
	 */
	List<? extends BigDecimal> getValues();
	final static VectorMeta metaData = new VectorMeta();
	
	@Override
	default RosettaMetaData<? extends Vector> metaData() {
		return metaData;
	} 
			
	static Vector.VectorBuilder builder() {
		return new Vector.VectorBuilderImpl();
	}
	
	default Class<? extends Vector> getType() {
		return Vector.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("values"), BigDecimal.class, getValues(), this);
		
	}
	
	
	interface VectorBuilder extends Vector, RosettaModelObjectBuilder {
		Vector.VectorBuilder addValues(BigDecimal values);
		Vector.VectorBuilder addValues(BigDecimal values, int _idx);
		Vector.VectorBuilder addValues(List<? extends BigDecimal> values);
		Vector.VectorBuilder setValues(List<? extends BigDecimal> values);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("values"), BigDecimal.class, getValues(), this);
			
		}
		
	}
	
	//Vector.VectorImpl
	class VectorImpl implements Vector {
		private final List<? extends BigDecimal> values;
		
		protected VectorImpl(Vector.VectorBuilder builder) {
			this.values = ofNullable(builder.getValues()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		public List<? extends BigDecimal> getValues() {
			return values;
		}
		
		@Override
		public Vector build() {
			return this;
		}
		
		@Override
		public Vector.VectorBuilder toBuilder() {
			Vector.VectorBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Vector.VectorBuilder builder) {
			ofNullable(getValues()).ifPresent(builder::setValues);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Vector _that = getType().cast(o);
		
			if (!ListEquals.listEquals(values, _that.getValues())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (values != null ? values.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Vector {" +
				"values=" + this.values +
			'}';
		}
	}
	
	//Vector.VectorBuilderImpl
	class VectorBuilderImpl implements Vector.VectorBuilder {
	
		protected List<BigDecimal> values = new ArrayList<>();
	
		public VectorBuilderImpl() {
		}
	
		@Override
		public List<? extends BigDecimal> getValues() {
			return values;
		}
		
	
		@Override
		public Vector.VectorBuilder addValues(BigDecimal values) {
			if (values!=null) this.values.add(values);
			return this;
		}
		
		@Override
		public Vector.VectorBuilder addValues(BigDecimal values, int _idx) {
			getIndex(this.values, _idx, () -> values);
			return this;
		}
		@Override 
		public Vector.VectorBuilder addValues(List<? extends BigDecimal> valuess) {
			if (valuess != null) {
				for (BigDecimal toAdd : valuess) {
					this.values.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public Vector.VectorBuilder setValues(List<? extends BigDecimal> valuess) {
			if (valuess == null)  {
				this.values = new ArrayList<>();
			}
			else {
				this.values = valuess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public Vector build() {
			return new Vector.VectorImpl(this);
		}
		
		@Override
		public Vector.VectorBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Vector.VectorBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValues()!=null && !getValues().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Vector.VectorBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Vector.VectorBuilder o = (Vector.VectorBuilder) other;
			
			
			merger.mergeBasic(getValues(), o.getValues(), (Consumer<BigDecimal>) this::addValues);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Vector _that = getType().cast(o);
		
			if (!ListEquals.listEquals(values, _that.getValues())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (values != null ? values.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VectorBuilder {" +
				"values=" + this.values +
			'}';
		}
	}
}
