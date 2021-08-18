package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.DeliveryAmountMeta;
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
 * A class to specify the application of Interest Amount with respect the Delivery Amount. ISDA 2016 Japanese Law Credit Support Annex for Initial Margin, paragraph 13, General Principles, (n)(ii).
 * @version ${project.version}
 */
@RosettaClass

public interface DeliveryAmount extends RosettaModelObject {
	DeliveryAmount build();
	DeliveryAmount.DeliveryAmountBuilder toBuilder();
	
	/**
	 * The custom election that might be specified by the parties to the agreement.
	 */
	String getCustomElection();
	/**
	 * The standard election as specified by an enumeration.
	 */
	DeliveryAmountElectionEnum getStandardElection();
	final static DeliveryAmountMeta metaData = new DeliveryAmountMeta();
	
	@Override
	default RosettaMetaData<? extends DeliveryAmount> metaData() {
		return metaData;
	} 
			
	static DeliveryAmount.DeliveryAmountBuilder builder() {
		return new DeliveryAmount.DeliveryAmountBuilderImpl();
	}
	
	default Class<? extends DeliveryAmount> getType() {
		return DeliveryAmount.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("customElection"), String.class, getCustomElection(), this);
		processor.processBasic(path.newSubPath("standardElection"), DeliveryAmountElectionEnum.class, getStandardElection(), this);
		
	}
	
	
	interface DeliveryAmountBuilder extends DeliveryAmount, RosettaModelObjectBuilder {
		DeliveryAmount.DeliveryAmountBuilder setCustomElection(String customElection);
		DeliveryAmount.DeliveryAmountBuilder setStandardElection(DeliveryAmountElectionEnum standardElection);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("customElection"), String.class, getCustomElection(), this);
			processor.processBasic(path.newSubPath("standardElection"), DeliveryAmountElectionEnum.class, getStandardElection(), this);
			
		}
		
	}
	
	//DeliveryAmount.DeliveryAmountImpl
	class DeliveryAmountImpl implements DeliveryAmount {
		private final String customElection;
		private final DeliveryAmountElectionEnum standardElection;
		
		protected DeliveryAmountImpl(DeliveryAmount.DeliveryAmountBuilder builder) {
			this.customElection = builder.getCustomElection();
			this.standardElection = builder.getStandardElection();
		}
		
		@Override
		public String getCustomElection() {
			return customElection;
		}
		
		@Override
		public DeliveryAmountElectionEnum getStandardElection() {
			return standardElection;
		}
		
		@Override
		public DeliveryAmount build() {
			return this;
		}
		
		@Override
		public DeliveryAmount.DeliveryAmountBuilder toBuilder() {
			DeliveryAmount.DeliveryAmountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DeliveryAmount.DeliveryAmountBuilder builder) {
			ofNullable(getCustomElection()).ifPresent(builder::setCustomElection);
			ofNullable(getStandardElection()).ifPresent(builder::setStandardElection);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeliveryAmount _that = getType().cast(o);
		
			if (!Objects.equals(customElection, _that.getCustomElection())) return false;
			if (!Objects.equals(standardElection, _that.getStandardElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (customElection != null ? customElection.hashCode() : 0);
			_result = 31 * _result + (standardElection != null ? standardElection.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeliveryAmount {" +
				"customElection=" + this.customElection + ", " +
				"standardElection=" + this.standardElection +
			'}';
		}
	}
	
	//DeliveryAmount.DeliveryAmountBuilderImpl
	class DeliveryAmountBuilderImpl implements DeliveryAmount.DeliveryAmountBuilder {
	
		protected String customElection;
		protected DeliveryAmountElectionEnum standardElection;
	
		public DeliveryAmountBuilderImpl() {
		}
	
		@Override
		public String getCustomElection() {
			return customElection;
		}
		
		@Override
		public DeliveryAmountElectionEnum getStandardElection() {
			return standardElection;
		}
		
	
		@Override
		public DeliveryAmount.DeliveryAmountBuilder setCustomElection(String customElection) {
			this.customElection = customElection==null?null:customElection;
			return this;
		}
		@Override
		public DeliveryAmount.DeliveryAmountBuilder setStandardElection(DeliveryAmountElectionEnum standardElection) {
			this.standardElection = standardElection==null?null:standardElection;
			return this;
		}
		
		@Override
		public DeliveryAmount build() {
			return new DeliveryAmount.DeliveryAmountImpl(this);
		}
		
		@Override
		public DeliveryAmount.DeliveryAmountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeliveryAmount.DeliveryAmountBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCustomElection()!=null) return true;
			if (getStandardElection()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DeliveryAmount.DeliveryAmountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DeliveryAmount.DeliveryAmountBuilder o = (DeliveryAmount.DeliveryAmountBuilder) other;
			
			
			merger.mergeBasic(getCustomElection(), o.getCustomElection(), this::setCustomElection);
			merger.mergeBasic(getStandardElection(), o.getStandardElection(), this::setStandardElection);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DeliveryAmount _that = getType().cast(o);
		
			if (!Objects.equals(customElection, _that.getCustomElection())) return false;
			if (!Objects.equals(standardElection, _that.getStandardElection())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (customElection != null ? customElection.hashCode() : 0);
			_result = 31 * _result + (standardElection != null ? standardElection.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DeliveryAmountBuilder {" +
				"customElection=" + this.customElection + ", " +
				"standardElection=" + this.standardElection +
			'}';
		}
	}
}
