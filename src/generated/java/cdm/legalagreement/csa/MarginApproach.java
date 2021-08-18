package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.MarginApproachMeta;
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
 * A class for selection of Margin Approach.
 * @version ${project.version}
 */
@RosettaClass

public interface MarginApproach extends RosettaModelObject {
	MarginApproach build();
	MarginApproach.MarginApproachBuilder toBuilder();
	
	/**
	 */
	MarginApproachEnum getMarginApproach();
	final static MarginApproachMeta metaData = new MarginApproachMeta();
	
	@Override
	default RosettaMetaData<? extends MarginApproach> metaData() {
		return metaData;
	} 
			
	static MarginApproach.MarginApproachBuilder builder() {
		return new MarginApproach.MarginApproachBuilderImpl();
	}
	
	default Class<? extends MarginApproach> getType() {
		return MarginApproach.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("marginApproach"), MarginApproachEnum.class, getMarginApproach(), this);
		
	}
	
	
	interface MarginApproachBuilder extends MarginApproach, RosettaModelObjectBuilder {
		MarginApproach.MarginApproachBuilder setMarginApproach(MarginApproachEnum marginApproach);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("marginApproach"), MarginApproachEnum.class, getMarginApproach(), this);
			
		}
		
	}
	
	//MarginApproach.MarginApproachImpl
	class MarginApproachImpl implements MarginApproach {
		private final MarginApproachEnum marginApproach;
		
		protected MarginApproachImpl(MarginApproach.MarginApproachBuilder builder) {
			this.marginApproach = builder.getMarginApproach();
		}
		
		@Override
		public MarginApproachEnum getMarginApproach() {
			return marginApproach;
		}
		
		@Override
		public MarginApproach build() {
			return this;
		}
		
		@Override
		public MarginApproach.MarginApproachBuilder toBuilder() {
			MarginApproach.MarginApproachBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MarginApproach.MarginApproachBuilder builder) {
			ofNullable(getMarginApproach()).ifPresent(builder::setMarginApproach);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginApproach _that = getType().cast(o);
		
			if (!Objects.equals(marginApproach, _that.getMarginApproach())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (marginApproach != null ? marginApproach.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginApproach {" +
				"marginApproach=" + this.marginApproach +
			'}';
		}
	}
	
	//MarginApproach.MarginApproachBuilderImpl
	class MarginApproachBuilderImpl implements MarginApproach.MarginApproachBuilder {
	
		protected MarginApproachEnum marginApproach;
	
		public MarginApproachBuilderImpl() {
		}
	
		@Override
		public MarginApproachEnum getMarginApproach() {
			return marginApproach;
		}
		
	
		@Override
		public MarginApproach.MarginApproachBuilder setMarginApproach(MarginApproachEnum marginApproach) {
			this.marginApproach = marginApproach==null?null:marginApproach;
			return this;
		}
		
		@Override
		public MarginApproach build() {
			return new MarginApproach.MarginApproachImpl(this);
		}
		
		@Override
		public MarginApproach.MarginApproachBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginApproach.MarginApproachBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMarginApproach()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginApproach.MarginApproachBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MarginApproach.MarginApproachBuilder o = (MarginApproach.MarginApproachBuilder) other;
			
			
			merger.mergeBasic(getMarginApproach(), o.getMarginApproach(), this::setMarginApproach);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginApproach _that = getType().cast(o);
		
			if (!Objects.equals(marginApproach, _that.getMarginApproach())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (marginApproach != null ? marginApproach.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginApproachBuilder {" +
				"marginApproach=" + this.marginApproach +
			'}';
		}
	}
}
