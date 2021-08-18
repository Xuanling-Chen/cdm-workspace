package cdm.event.workflow;

import cdm.event.workflow.meta.CreditLimitUtilisationPositionMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface CreditLimitUtilisationPosition extends RosettaModelObject {
	CreditLimitUtilisationPosition build();
	CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder toBuilder();
	
	/**
	 * Global credit limit utilisation amount, agnostic of long/short position direction.
	 */
	BigDecimal getGlobal();
	/**
	 * Credit limit utilisation attributable to long positions.
	 */
	BigDecimal getLongPosition();
	/**
	 * Credit limit utilisation attributable to short positions.
	 */
	BigDecimal getShortPosition();
	final static CreditLimitUtilisationPositionMeta metaData = new CreditLimitUtilisationPositionMeta();
	
	@Override
	default RosettaMetaData<? extends CreditLimitUtilisationPosition> metaData() {
		return metaData;
	} 
			
	static CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder builder() {
		return new CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilderImpl();
	}
	
	default Class<? extends CreditLimitUtilisationPosition> getType() {
		return CreditLimitUtilisationPosition.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("global"), BigDecimal.class, getGlobal(), this);
		processor.processBasic(path.newSubPath("longPosition"), BigDecimal.class, getLongPosition(), this);
		processor.processBasic(path.newSubPath("shortPosition"), BigDecimal.class, getShortPosition(), this);
		
	}
	
	
	interface CreditLimitUtilisationPositionBuilder extends CreditLimitUtilisationPosition, RosettaModelObjectBuilder {
		CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder setGlobal(BigDecimal global);
		CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder setLongPosition(BigDecimal longPosition);
		CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder setShortPosition(BigDecimal shortPosition);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("global"), BigDecimal.class, getGlobal(), this);
			processor.processBasic(path.newSubPath("longPosition"), BigDecimal.class, getLongPosition(), this);
			processor.processBasic(path.newSubPath("shortPosition"), BigDecimal.class, getShortPosition(), this);
			
		}
		
	}
	
	//CreditLimitUtilisationPosition.CreditLimitUtilisationPositionImpl
	class CreditLimitUtilisationPositionImpl implements CreditLimitUtilisationPosition {
		private final BigDecimal global;
		private final BigDecimal longPosition;
		private final BigDecimal shortPosition;
		
		protected CreditLimitUtilisationPositionImpl(CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder builder) {
			this.global = builder.getGlobal();
			this.longPosition = builder.getLongPosition();
			this.shortPosition = builder.getShortPosition();
		}
		
		@Override
		public BigDecimal getGlobal() {
			return global;
		}
		
		@Override
		public BigDecimal getLongPosition() {
			return longPosition;
		}
		
		@Override
		public BigDecimal getShortPosition() {
			return shortPosition;
		}
		
		@Override
		public CreditLimitUtilisationPosition build() {
			return this;
		}
		
		@Override
		public CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder toBuilder() {
			CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder builder) {
			ofNullable(getGlobal()).ifPresent(builder::setGlobal);
			ofNullable(getLongPosition()).ifPresent(builder::setLongPosition);
			ofNullable(getShortPosition()).ifPresent(builder::setShortPosition);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitUtilisationPosition _that = getType().cast(o);
		
			if (!Objects.equals(global, _that.getGlobal())) return false;
			if (!Objects.equals(longPosition, _that.getLongPosition())) return false;
			if (!Objects.equals(shortPosition, _that.getShortPosition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (global != null ? global.hashCode() : 0);
			_result = 31 * _result + (longPosition != null ? longPosition.hashCode() : 0);
			_result = 31 * _result + (shortPosition != null ? shortPosition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitUtilisationPosition {" +
				"global=" + this.global + ", " +
				"longPosition=" + this.longPosition + ", " +
				"shortPosition=" + this.shortPosition +
			'}';
		}
	}
	
	//CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilderImpl
	class CreditLimitUtilisationPositionBuilderImpl implements CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder {
	
		protected BigDecimal global;
		protected BigDecimal longPosition;
		protected BigDecimal shortPosition;
	
		public CreditLimitUtilisationPositionBuilderImpl() {
		}
	
		@Override
		public BigDecimal getGlobal() {
			return global;
		}
		
		@Override
		public BigDecimal getLongPosition() {
			return longPosition;
		}
		
		@Override
		public BigDecimal getShortPosition() {
			return shortPosition;
		}
		
	
		@Override
		public CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder setGlobal(BigDecimal global) {
			this.global = global==null?null:global;
			return this;
		}
		@Override
		public CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder setLongPosition(BigDecimal longPosition) {
			this.longPosition = longPosition==null?null:longPosition;
			return this;
		}
		@Override
		public CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder setShortPosition(BigDecimal shortPosition) {
			this.shortPosition = shortPosition==null?null:shortPosition;
			return this;
		}
		
		@Override
		public CreditLimitUtilisationPosition build() {
			return new CreditLimitUtilisationPosition.CreditLimitUtilisationPositionImpl(this);
		}
		
		@Override
		public CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getGlobal()!=null) return true;
			if (getLongPosition()!=null) return true;
			if (getShortPosition()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder o = (CreditLimitUtilisationPosition.CreditLimitUtilisationPositionBuilder) other;
			
			
			merger.mergeBasic(getGlobal(), o.getGlobal(), this::setGlobal);
			merger.mergeBasic(getLongPosition(), o.getLongPosition(), this::setLongPosition);
			merger.mergeBasic(getShortPosition(), o.getShortPosition(), this::setShortPosition);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditLimitUtilisationPosition _that = getType().cast(o);
		
			if (!Objects.equals(global, _that.getGlobal())) return false;
			if (!Objects.equals(longPosition, _that.getLongPosition())) return false;
			if (!Objects.equals(shortPosition, _that.getShortPosition())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (global != null ? global.hashCode() : 0);
			_result = 31 * _result + (longPosition != null ? longPosition.hashCode() : 0);
			_result = 31 * _result + (shortPosition != null ? shortPosition.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditLimitUtilisationPositionBuilder {" +
				"global=" + this.global + ", " +
				"longPosition=" + this.longPosition + ", " +
				"shortPosition=" + this.shortPosition +
			'}';
		}
	}
}
