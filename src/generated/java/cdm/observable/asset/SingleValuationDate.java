package cdm.observable.asset;

import cdm.observable.asset.meta.SingleValuationDateMeta;
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
 * A class to specify the number of business days after satisfaction of all conditions to settlement.
 * @version ${project.version}
 */
@RosettaClass

public interface SingleValuationDate extends RosettaModelObject {
	SingleValuationDate build();
	SingleValuationDate.SingleValuationDateBuilder toBuilder();
	
	/**
	 * A number of business days. Its precise meaning is dependant on the context in which this element is used. ISDA 2003 Term: Business Day.
	 */
	Integer getBusinessDays();
	final static SingleValuationDateMeta metaData = new SingleValuationDateMeta();
	
	@Override
	default RosettaMetaData<? extends SingleValuationDate> metaData() {
		return metaData;
	} 
			
	static SingleValuationDate.SingleValuationDateBuilder builder() {
		return new SingleValuationDate.SingleValuationDateBuilderImpl();
	}
	
	default Class<? extends SingleValuationDate> getType() {
		return SingleValuationDate.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("businessDays"), Integer.class, getBusinessDays(), this);
		
	}
	
	
	interface SingleValuationDateBuilder extends SingleValuationDate, RosettaModelObjectBuilder {
		SingleValuationDate.SingleValuationDateBuilder setBusinessDays(Integer businessDays);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("businessDays"), Integer.class, getBusinessDays(), this);
			
		}
		
	}
	
	//SingleValuationDate.SingleValuationDateImpl
	class SingleValuationDateImpl implements SingleValuationDate {
		private final Integer businessDays;
		
		protected SingleValuationDateImpl(SingleValuationDate.SingleValuationDateBuilder builder) {
			this.businessDays = builder.getBusinessDays();
		}
		
		@Override
		public Integer getBusinessDays() {
			return businessDays;
		}
		
		@Override
		public SingleValuationDate build() {
			return this;
		}
		
		@Override
		public SingleValuationDate.SingleValuationDateBuilder toBuilder() {
			SingleValuationDate.SingleValuationDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SingleValuationDate.SingleValuationDateBuilder builder) {
			ofNullable(getBusinessDays()).ifPresent(builder::setBusinessDays);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SingleValuationDate _that = getType().cast(o);
		
			if (!Objects.equals(businessDays, _that.getBusinessDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessDays != null ? businessDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SingleValuationDate {" +
				"businessDays=" + this.businessDays +
			'}';
		}
	}
	
	//SingleValuationDate.SingleValuationDateBuilderImpl
	class SingleValuationDateBuilderImpl implements SingleValuationDate.SingleValuationDateBuilder {
	
		protected Integer businessDays;
	
		public SingleValuationDateBuilderImpl() {
		}
	
		@Override
		public Integer getBusinessDays() {
			return businessDays;
		}
		
	
		@Override
		public SingleValuationDate.SingleValuationDateBuilder setBusinessDays(Integer businessDays) {
			this.businessDays = businessDays==null?null:businessDays;
			return this;
		}
		
		@Override
		public SingleValuationDate build() {
			return new SingleValuationDate.SingleValuationDateImpl(this);
		}
		
		@Override
		public SingleValuationDate.SingleValuationDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SingleValuationDate.SingleValuationDateBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBusinessDays()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SingleValuationDate.SingleValuationDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SingleValuationDate.SingleValuationDateBuilder o = (SingleValuationDate.SingleValuationDateBuilder) other;
			
			
			merger.mergeBasic(getBusinessDays(), o.getBusinessDays(), this::setBusinessDays);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SingleValuationDate _that = getType().cast(o);
		
			if (!Objects.equals(businessDays, _that.getBusinessDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessDays != null ? businessDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SingleValuationDateBuilder {" +
				"businessDays=" + this.businessDays +
			'}';
		}
	}
}
