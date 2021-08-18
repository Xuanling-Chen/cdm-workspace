package cdm.legalagreement.contract;

import cdm.legalagreement.contract.meta.BrokerConfirmationMeta;
import cdm.legalagreement.contract.metafields.FieldWithMetaBrokerConfirmationTypeEnum;
import cdm.legalagreement.contract.metafields.FieldWithMetaBrokerConfirmationTypeEnum.FieldWithMetaBrokerConfirmationTypeEnumBuilder;
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
 * Identifies the market sector in which the trade has been arranged.
 * @version ${project.version}
 */
@RosettaClass

public interface BrokerConfirmation extends RosettaModelObject {
	BrokerConfirmation build();
	BrokerConfirmation.BrokerConfirmationBuilder toBuilder();
	
	/**
	 * The type of broker confirmation executed between the parties.
	 */
	FieldWithMetaBrokerConfirmationTypeEnum getBrokerConfirmationType();
	final static BrokerConfirmationMeta metaData = new BrokerConfirmationMeta();
	
	@Override
	default RosettaMetaData<? extends BrokerConfirmation> metaData() {
		return metaData;
	} 
			
	static BrokerConfirmation.BrokerConfirmationBuilder builder() {
		return new BrokerConfirmation.BrokerConfirmationBuilderImpl();
	}
	
	default Class<? extends BrokerConfirmation> getType() {
		return BrokerConfirmation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("brokerConfirmationType"), processor, FieldWithMetaBrokerConfirmationTypeEnum.class, getBrokerConfirmationType());
	}
	
	
	interface BrokerConfirmationBuilder extends BrokerConfirmation, RosettaModelObjectBuilder {
		FieldWithMetaBrokerConfirmationTypeEnumBuilder getOrCreateBrokerConfirmationType();
		FieldWithMetaBrokerConfirmationTypeEnumBuilder getBrokerConfirmationType();
		BrokerConfirmation.BrokerConfirmationBuilder setBrokerConfirmationType(FieldWithMetaBrokerConfirmationTypeEnum brokerConfirmationType);
		BrokerConfirmation.BrokerConfirmationBuilder setBrokerConfirmationTypeValue(BrokerConfirmationTypeEnum brokerConfirmationType);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("brokerConfirmationType"), processor, FieldWithMetaBrokerConfirmationTypeEnumBuilder.class, getBrokerConfirmationType());
		}
		
	}
	
	//BrokerConfirmation.BrokerConfirmationImpl
	class BrokerConfirmationImpl implements BrokerConfirmation {
		private final FieldWithMetaBrokerConfirmationTypeEnum brokerConfirmationType;
		
		protected BrokerConfirmationImpl(BrokerConfirmation.BrokerConfirmationBuilder builder) {
			this.brokerConfirmationType = ofNullable(builder.getBrokerConfirmationType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public FieldWithMetaBrokerConfirmationTypeEnum getBrokerConfirmationType() {
			return brokerConfirmationType;
		}
		
		@Override
		public BrokerConfirmation build() {
			return this;
		}
		
		@Override
		public BrokerConfirmation.BrokerConfirmationBuilder toBuilder() {
			BrokerConfirmation.BrokerConfirmationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BrokerConfirmation.BrokerConfirmationBuilder builder) {
			ofNullable(getBrokerConfirmationType()).ifPresent(builder::setBrokerConfirmationType);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BrokerConfirmation _that = getType().cast(o);
		
			if (!Objects.equals(brokerConfirmationType, _that.getBrokerConfirmationType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (brokerConfirmationType != null ? brokerConfirmationType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BrokerConfirmation {" +
				"brokerConfirmationType=" + this.brokerConfirmationType +
			'}';
		}
	}
	
	//BrokerConfirmation.BrokerConfirmationBuilderImpl
	class BrokerConfirmationBuilderImpl implements BrokerConfirmation.BrokerConfirmationBuilder {
	
		protected FieldWithMetaBrokerConfirmationTypeEnumBuilder brokerConfirmationType;
	
		public BrokerConfirmationBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaBrokerConfirmationTypeEnumBuilder getBrokerConfirmationType() {
			return brokerConfirmationType;
		}
		
		@Override
		public FieldWithMetaBrokerConfirmationTypeEnumBuilder getOrCreateBrokerConfirmationType() {
			FieldWithMetaBrokerConfirmationTypeEnumBuilder result;
			if (brokerConfirmationType!=null) {
				result = brokerConfirmationType;
			}
			else {
				result = brokerConfirmationType = FieldWithMetaBrokerConfirmationTypeEnum.builder();
			}
			
			return result;
		}
		
	
		@Override
		public BrokerConfirmation.BrokerConfirmationBuilder setBrokerConfirmationType(FieldWithMetaBrokerConfirmationTypeEnum brokerConfirmationType) {
			this.brokerConfirmationType = brokerConfirmationType==null?null:brokerConfirmationType.toBuilder();
			return this;
		}
		
		@Override
		public BrokerConfirmation.BrokerConfirmationBuilder setBrokerConfirmationTypeValue(BrokerConfirmationTypeEnum brokerConfirmationType) {
			this.getOrCreateBrokerConfirmationType().setValue(brokerConfirmationType);
			return this;
		}
		
		@Override
		public BrokerConfirmation build() {
			return new BrokerConfirmation.BrokerConfirmationImpl(this);
		}
		
		@Override
		public BrokerConfirmation.BrokerConfirmationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BrokerConfirmation.BrokerConfirmationBuilder prune() {
			if (brokerConfirmationType!=null && !brokerConfirmationType.prune().hasData()) brokerConfirmationType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBrokerConfirmationType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BrokerConfirmation.BrokerConfirmationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BrokerConfirmation.BrokerConfirmationBuilder o = (BrokerConfirmation.BrokerConfirmationBuilder) other;
			
			merger.mergeRosetta(getBrokerConfirmationType(), o.getBrokerConfirmationType(), this::setBrokerConfirmationType);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BrokerConfirmation _that = getType().cast(o);
		
			if (!Objects.equals(brokerConfirmationType, _that.getBrokerConfirmationType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (brokerConfirmationType != null ? brokerConfirmationType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BrokerConfirmationBuilder {" +
				"brokerConfirmationType=" + this.brokerConfirmationType +
			'}';
		}
	}
}
