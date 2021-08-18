package cdm.regulation;

import cdm.regulation.meta.SwpMeta;
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

public interface Swp extends RosettaModelObject {
	Swp build();
	Swp.SwpBuilder toBuilder();
	
	/**
	 */
	SwpIn getSwpIn();
	/**
	 */
	SwpOut getSwpOut();
	final static SwpMeta metaData = new SwpMeta();
	
	@Override
	default RosettaMetaData<? extends Swp> metaData() {
		return metaData;
	} 
			
	static Swp.SwpBuilder builder() {
		return new Swp.SwpBuilderImpl();
	}
	
	default Class<? extends Swp> getType() {
		return Swp.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("swpIn"), processor, SwpIn.class, getSwpIn());
		processRosetta(path.newSubPath("swpOut"), processor, SwpOut.class, getSwpOut());
	}
	
	
	interface SwpBuilder extends Swp, RosettaModelObjectBuilder {
		SwpIn.SwpInBuilder getOrCreateSwpIn();
		SwpIn.SwpInBuilder getSwpIn();
		SwpOut.SwpOutBuilder getOrCreateSwpOut();
		SwpOut.SwpOutBuilder getSwpOut();
		Swp.SwpBuilder setSwpIn(SwpIn swpIn);
		Swp.SwpBuilder setSwpOut(SwpOut swpOut);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("swpIn"), processor, SwpIn.SwpInBuilder.class, getSwpIn());
			processRosetta(path.newSubPath("swpOut"), processor, SwpOut.SwpOutBuilder.class, getSwpOut());
		}
		
	}
	
	//Swp.SwpImpl
	class SwpImpl implements Swp {
		private final SwpIn swpIn;
		private final SwpOut swpOut;
		
		protected SwpImpl(Swp.SwpBuilder builder) {
			this.swpIn = ofNullable(builder.getSwpIn()).map(f->f.build()).orElse(null);
			this.swpOut = ofNullable(builder.getSwpOut()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public SwpIn getSwpIn() {
			return swpIn;
		}
		
		@Override
		public SwpOut getSwpOut() {
			return swpOut;
		}
		
		@Override
		public Swp build() {
			return this;
		}
		
		@Override
		public Swp.SwpBuilder toBuilder() {
			Swp.SwpBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Swp.SwpBuilder builder) {
			ofNullable(getSwpIn()).ifPresent(builder::setSwpIn);
			ofNullable(getSwpOut()).ifPresent(builder::setSwpOut);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Swp _that = getType().cast(o);
		
			if (!Objects.equals(swpIn, _that.getSwpIn())) return false;
			if (!Objects.equals(swpOut, _that.getSwpOut())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (swpIn != null ? swpIn.hashCode() : 0);
			_result = 31 * _result + (swpOut != null ? swpOut.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Swp {" +
				"swpIn=" + this.swpIn + ", " +
				"swpOut=" + this.swpOut +
			'}';
		}
	}
	
	//Swp.SwpBuilderImpl
	class SwpBuilderImpl implements Swp.SwpBuilder {
	
		protected SwpIn.SwpInBuilder swpIn;
		protected SwpOut.SwpOutBuilder swpOut;
	
		public SwpBuilderImpl() {
		}
	
		@Override
		public SwpIn.SwpInBuilder getSwpIn() {
			return swpIn;
		}
		
		@Override
		public SwpIn.SwpInBuilder getOrCreateSwpIn() {
			SwpIn.SwpInBuilder result;
			if (swpIn!=null) {
				result = swpIn;
			}
			else {
				result = swpIn = SwpIn.builder();
			}
			
			return result;
		}
		
		@Override
		public SwpOut.SwpOutBuilder getSwpOut() {
			return swpOut;
		}
		
		@Override
		public SwpOut.SwpOutBuilder getOrCreateSwpOut() {
			SwpOut.SwpOutBuilder result;
			if (swpOut!=null) {
				result = swpOut;
			}
			else {
				result = swpOut = SwpOut.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Swp.SwpBuilder setSwpIn(SwpIn swpIn) {
			this.swpIn = swpIn==null?null:swpIn.toBuilder();
			return this;
		}
		@Override
		public Swp.SwpBuilder setSwpOut(SwpOut swpOut) {
			this.swpOut = swpOut==null?null:swpOut.toBuilder();
			return this;
		}
		
		@Override
		public Swp build() {
			return new Swp.SwpImpl(this);
		}
		
		@Override
		public Swp.SwpBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Swp.SwpBuilder prune() {
			if (swpIn!=null && !swpIn.prune().hasData()) swpIn = null;
			if (swpOut!=null && !swpOut.prune().hasData()) swpOut = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSwpIn()!=null && getSwpIn().hasData()) return true;
			if (getSwpOut()!=null && getSwpOut().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Swp.SwpBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Swp.SwpBuilder o = (Swp.SwpBuilder) other;
			
			merger.mergeRosetta(getSwpIn(), o.getSwpIn(), this::setSwpIn);
			merger.mergeRosetta(getSwpOut(), o.getSwpOut(), this::setSwpOut);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Swp _that = getType().cast(o);
		
			if (!Objects.equals(swpIn, _that.getSwpIn())) return false;
			if (!Objects.equals(swpOut, _that.getSwpOut())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (swpIn != null ? swpIn.hashCode() : 0);
			_result = 31 * _result + (swpOut != null ? swpOut.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SwpBuilder {" +
				"swpIn=" + this.swpIn + ", " +
				"swpOut=" + this.swpOut +
			'}';
		}
	}
}
