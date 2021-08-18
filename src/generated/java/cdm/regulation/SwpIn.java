package cdm.regulation;

import cdm.regulation.meta.SwpInMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface SwpIn extends RosettaModelObject {
	SwpIn build();
	SwpIn.SwpInBuilder toBuilder();
	
	/**
	 */
	Sngl getSngl();
	final static SwpInMeta metaData = new SwpInMeta();
	
	@Override
	default RosettaMetaData<? extends SwpIn> metaData() {
		return metaData;
	} 
			
	static SwpIn.SwpInBuilder builder() {
		return new SwpIn.SwpInBuilderImpl();
	}
	
	default Class<? extends SwpIn> getType() {
		return SwpIn.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("sngl"), processor, Sngl.class, getSngl());
	}
	
	
	interface SwpInBuilder extends SwpIn, RosettaModelObjectBuilder {
		Sngl.SnglBuilder getOrCreateSngl();
		Sngl.SnglBuilder getSngl();
		SwpIn.SwpInBuilder setSngl(Sngl sngl);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("sngl"), processor, Sngl.SnglBuilder.class, getSngl());
		}
		
	}
	
	//SwpIn.SwpInImpl
	class SwpInImpl implements SwpIn {
		private final Sngl sngl;
		
		protected SwpInImpl(SwpIn.SwpInBuilder builder) {
			this.sngl = ofNullable(builder.getSngl()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Sngl getSngl() {
			return sngl;
		}
		
		@Override
		public SwpIn build() {
			return this;
		}
		
		@Override
		public SwpIn.SwpInBuilder toBuilder() {
			SwpIn.SwpInBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SwpIn.SwpInBuilder builder) {
			ofNullable(getSngl()).ifPresent(builder::setSngl);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SwpIn _that = getType().cast(o);
		
			if (!Objects.equals(sngl, _that.getSngl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sngl != null ? sngl.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SwpIn {" +
				"sngl=" + this.sngl +
			'}';
		}
	}
	
	//SwpIn.SwpInBuilderImpl
	class SwpInBuilderImpl implements SwpIn.SwpInBuilder {
	
		protected Sngl.SnglBuilder sngl;
	
		public SwpInBuilderImpl() {
		}
	
		@Override
		public Sngl.SnglBuilder getSngl() {
			return sngl;
		}
		
		@Override
		public Sngl.SnglBuilder getOrCreateSngl() {
			Sngl.SnglBuilder result;
			if (sngl!=null) {
				result = sngl;
			}
			else {
				result = sngl = Sngl.builder();
			}
			
			return result;
		}
		
	
		@Override
		public SwpIn.SwpInBuilder setSngl(Sngl sngl) {
			this.sngl = sngl==null?null:sngl.toBuilder();
			return this;
		}
		
		@Override
		public SwpIn build() {
			return new SwpIn.SwpInImpl(this);
		}
		
		@Override
		public SwpIn.SwpInBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SwpIn.SwpInBuilder prune() {
			if (sngl!=null && !sngl.prune().hasData()) sngl = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSngl()!=null && getSngl().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SwpIn.SwpInBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SwpIn.SwpInBuilder o = (SwpIn.SwpInBuilder) other;
			
			merger.mergeRosetta(getSngl(), o.getSngl(), this::setSngl);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SwpIn _that = getType().cast(o);
		
			if (!Objects.equals(sngl, _that.getSngl())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sngl != null ? sngl.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SwpInBuilder {" +
				"sngl=" + this.sngl +
			'}';
		}
	}
}
