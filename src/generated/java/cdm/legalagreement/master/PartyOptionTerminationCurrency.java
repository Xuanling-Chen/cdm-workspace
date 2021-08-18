package cdm.legalagreement.master;

import cdm.legalagreement.common.TerminationCurrencyConditionEnum;
import cdm.legalagreement.master.meta.PartyOptionTerminationCurrencyMeta;
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
 * Specifies mechanism for Termination currency to be selected by the Non-defaulting Party/party which is not the Affected Party.
 * @version ${project.version}
 */
@RosettaClass

public interface PartyOptionTerminationCurrency extends RosettaModelObject {
	PartyOptionTerminationCurrency build();
	PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder toBuilder();
	
	/**
	 * Specifies termination currency where there are two Affected Parties and they cannot agree on the termination currency.
	 */
	String getBothAffectedTermCurrencyOption();
	/**
	 * Specifies the enumerated conditions for selection of the termination currency.
	 */
	TerminationCurrencyConditionEnum getTerminationCurrencyCondition();
	/**
	 * Specifies alternative conditions for selection of the termination currency.
	 */
	String getTerminationCurrencySpecifiedCondition();
	final static PartyOptionTerminationCurrencyMeta metaData = new PartyOptionTerminationCurrencyMeta();
	
	@Override
	default RosettaMetaData<? extends PartyOptionTerminationCurrency> metaData() {
		return metaData;
	} 
			
	static PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder builder() {
		return new PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilderImpl();
	}
	
	default Class<? extends PartyOptionTerminationCurrency> getType() {
		return PartyOptionTerminationCurrency.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("bothAffectedTermCurrencyOption"), String.class, getBothAffectedTermCurrencyOption(), this);
		processor.processBasic(path.newSubPath("terminationCurrencyCondition"), TerminationCurrencyConditionEnum.class, getTerminationCurrencyCondition(), this);
		processor.processBasic(path.newSubPath("terminationCurrencySpecifiedCondition"), String.class, getTerminationCurrencySpecifiedCondition(), this);
		
	}
	
	
	interface PartyOptionTerminationCurrencyBuilder extends PartyOptionTerminationCurrency, RosettaModelObjectBuilder {
		PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder setBothAffectedTermCurrencyOption(String bothAffectedTermCurrencyOption);
		PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder setTerminationCurrencyCondition(TerminationCurrencyConditionEnum terminationCurrencyCondition);
		PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder setTerminationCurrencySpecifiedCondition(String terminationCurrencySpecifiedCondition);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("bothAffectedTermCurrencyOption"), String.class, getBothAffectedTermCurrencyOption(), this);
			processor.processBasic(path.newSubPath("terminationCurrencyCondition"), TerminationCurrencyConditionEnum.class, getTerminationCurrencyCondition(), this);
			processor.processBasic(path.newSubPath("terminationCurrencySpecifiedCondition"), String.class, getTerminationCurrencySpecifiedCondition(), this);
			
		}
		
	}
	
	//PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyImpl
	class PartyOptionTerminationCurrencyImpl implements PartyOptionTerminationCurrency {
		private final String bothAffectedTermCurrencyOption;
		private final TerminationCurrencyConditionEnum terminationCurrencyCondition;
		private final String terminationCurrencySpecifiedCondition;
		
		protected PartyOptionTerminationCurrencyImpl(PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder builder) {
			this.bothAffectedTermCurrencyOption = builder.getBothAffectedTermCurrencyOption();
			this.terminationCurrencyCondition = builder.getTerminationCurrencyCondition();
			this.terminationCurrencySpecifiedCondition = builder.getTerminationCurrencySpecifiedCondition();
		}
		
		@Override
		public String getBothAffectedTermCurrencyOption() {
			return bothAffectedTermCurrencyOption;
		}
		
		@Override
		public TerminationCurrencyConditionEnum getTerminationCurrencyCondition() {
			return terminationCurrencyCondition;
		}
		
		@Override
		public String getTerminationCurrencySpecifiedCondition() {
			return terminationCurrencySpecifiedCondition;
		}
		
		@Override
		public PartyOptionTerminationCurrency build() {
			return this;
		}
		
		@Override
		public PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder toBuilder() {
			PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder builder) {
			ofNullable(getBothAffectedTermCurrencyOption()).ifPresent(builder::setBothAffectedTermCurrencyOption);
			ofNullable(getTerminationCurrencyCondition()).ifPresent(builder::setTerminationCurrencyCondition);
			ofNullable(getTerminationCurrencySpecifiedCondition()).ifPresent(builder::setTerminationCurrencySpecifiedCondition);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyOptionTerminationCurrency _that = getType().cast(o);
		
			if (!Objects.equals(bothAffectedTermCurrencyOption, _that.getBothAffectedTermCurrencyOption())) return false;
			if (!Objects.equals(terminationCurrencyCondition, _that.getTerminationCurrencyCondition())) return false;
			if (!Objects.equals(terminationCurrencySpecifiedCondition, _that.getTerminationCurrencySpecifiedCondition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bothAffectedTermCurrencyOption != null ? bothAffectedTermCurrencyOption.hashCode() : 0);
			_result = 31 * _result + (terminationCurrencyCondition != null ? terminationCurrencyCondition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (terminationCurrencySpecifiedCondition != null ? terminationCurrencySpecifiedCondition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyOptionTerminationCurrency {" +
				"bothAffectedTermCurrencyOption=" + this.bothAffectedTermCurrencyOption + ", " +
				"terminationCurrencyCondition=" + this.terminationCurrencyCondition + ", " +
				"terminationCurrencySpecifiedCondition=" + this.terminationCurrencySpecifiedCondition +
			'}';
		}
	}
	
	//PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilderImpl
	class PartyOptionTerminationCurrencyBuilderImpl implements PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder {
	
		protected String bothAffectedTermCurrencyOption;
		protected TerminationCurrencyConditionEnum terminationCurrencyCondition;
		protected String terminationCurrencySpecifiedCondition;
	
		public PartyOptionTerminationCurrencyBuilderImpl() {
		}
	
		@Override
		public String getBothAffectedTermCurrencyOption() {
			return bothAffectedTermCurrencyOption;
		}
		
		@Override
		public TerminationCurrencyConditionEnum getTerminationCurrencyCondition() {
			return terminationCurrencyCondition;
		}
		
		@Override
		public String getTerminationCurrencySpecifiedCondition() {
			return terminationCurrencySpecifiedCondition;
		}
		
	
		@Override
		public PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder setBothAffectedTermCurrencyOption(String bothAffectedTermCurrencyOption) {
			this.bothAffectedTermCurrencyOption = bothAffectedTermCurrencyOption==null?null:bothAffectedTermCurrencyOption;
			return this;
		}
		@Override
		public PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder setTerminationCurrencyCondition(TerminationCurrencyConditionEnum terminationCurrencyCondition) {
			this.terminationCurrencyCondition = terminationCurrencyCondition==null?null:terminationCurrencyCondition;
			return this;
		}
		@Override
		public PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder setTerminationCurrencySpecifiedCondition(String terminationCurrencySpecifiedCondition) {
			this.terminationCurrencySpecifiedCondition = terminationCurrencySpecifiedCondition==null?null:terminationCurrencySpecifiedCondition;
			return this;
		}
		
		@Override
		public PartyOptionTerminationCurrency build() {
			return new PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyImpl(this);
		}
		
		@Override
		public PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBothAffectedTermCurrencyOption()!=null) return true;
			if (getTerminationCurrencyCondition()!=null) return true;
			if (getTerminationCurrencySpecifiedCondition()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder o = (PartyOptionTerminationCurrency.PartyOptionTerminationCurrencyBuilder) other;
			
			
			merger.mergeBasic(getBothAffectedTermCurrencyOption(), o.getBothAffectedTermCurrencyOption(), this::setBothAffectedTermCurrencyOption);
			merger.mergeBasic(getTerminationCurrencyCondition(), o.getTerminationCurrencyCondition(), this::setTerminationCurrencyCondition);
			merger.mergeBasic(getTerminationCurrencySpecifiedCondition(), o.getTerminationCurrencySpecifiedCondition(), this::setTerminationCurrencySpecifiedCondition);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyOptionTerminationCurrency _that = getType().cast(o);
		
			if (!Objects.equals(bothAffectedTermCurrencyOption, _that.getBothAffectedTermCurrencyOption())) return false;
			if (!Objects.equals(terminationCurrencyCondition, _that.getTerminationCurrencyCondition())) return false;
			if (!Objects.equals(terminationCurrencySpecifiedCondition, _that.getTerminationCurrencySpecifiedCondition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bothAffectedTermCurrencyOption != null ? bothAffectedTermCurrencyOption.hashCode() : 0);
			_result = 31 * _result + (terminationCurrencyCondition != null ? terminationCurrencyCondition.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (terminationCurrencySpecifiedCondition != null ? terminationCurrencySpecifiedCondition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyOptionTerminationCurrencyBuilder {" +
				"bothAffectedTermCurrencyOption=" + this.bothAffectedTermCurrencyOption + ", " +
				"terminationCurrencyCondition=" + this.terminationCurrencyCondition + ", " +
				"terminationCurrencySpecifiedCondition=" + this.terminationCurrencySpecifiedCondition +
			'}';
		}
	}
}
