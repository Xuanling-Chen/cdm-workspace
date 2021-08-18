package cdm.event.common;

import cdm.event.common.meta.TransferBaseMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface TransferBase extends RosettaModelObject {
	TransferBase build();
	TransferBase.TransferBaseBuilder toBuilder();
	
	/**
	 * The identifier that can be associated with each of the transfer components
	 */
	FieldWithMetaString getIdentifier();
	/**
	 * The calculation details underlying the transfer amount, when applicable.
	 */
	TransferCalculation getTransferCalculation();
	final static TransferBaseMeta metaData = new TransferBaseMeta();
	
	@Override
	default RosettaMetaData<? extends TransferBase> metaData() {
		return metaData;
	} 
			
	static TransferBase.TransferBaseBuilder builder() {
		return new TransferBase.TransferBaseBuilderImpl();
	}
	
	default Class<? extends TransferBase> getType() {
		return TransferBase.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("identifier"), processor, FieldWithMetaString.class, getIdentifier());
		processRosetta(path.newSubPath("transferCalculation"), processor, TransferCalculation.class, getTransferCalculation());
	}
	
	
	interface TransferBaseBuilder extends TransferBase, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateIdentifier();
		FieldWithMetaStringBuilder getIdentifier();
		TransferCalculation.TransferCalculationBuilder getOrCreateTransferCalculation();
		TransferCalculation.TransferCalculationBuilder getTransferCalculation();
		TransferBase.TransferBaseBuilder setIdentifier(FieldWithMetaString identifier);
		TransferBase.TransferBaseBuilder setIdentifierValue(String identifier);
		TransferBase.TransferBaseBuilder setTransferCalculation(TransferCalculation transferCalculation);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("identifier"), processor, FieldWithMetaStringBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("transferCalculation"), processor, TransferCalculation.TransferCalculationBuilder.class, getTransferCalculation());
		}
		
	}
	
	//TransferBase.TransferBaseImpl
	class TransferBaseImpl implements TransferBase {
		private final FieldWithMetaString identifier;
		private final TransferCalculation transferCalculation;
		
		protected TransferBaseImpl(TransferBase.TransferBaseBuilder builder) {
			this.identifier = ofNullable(builder.getIdentifier()).map(f->f.build()).orElse(null);
			this.transferCalculation = ofNullable(builder.getTransferCalculation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public FieldWithMetaString getIdentifier() {
			return identifier;
		}
		
		@Override
		public TransferCalculation getTransferCalculation() {
			return transferCalculation;
		}
		
		@Override
		public TransferBase build() {
			return this;
		}
		
		@Override
		public TransferBase.TransferBaseBuilder toBuilder() {
			TransferBase.TransferBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TransferBase.TransferBaseBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getTransferCalculation()).ifPresent(builder::setTransferCalculation);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransferBase _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(transferCalculation, _that.getTransferCalculation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (transferCalculation != null ? transferCalculation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferBase {" +
				"identifier=" + this.identifier + ", " +
				"transferCalculation=" + this.transferCalculation +
			'}';
		}
	}
	
	//TransferBase.TransferBaseBuilderImpl
	class TransferBaseBuilderImpl implements TransferBase.TransferBaseBuilder {
	
		protected FieldWithMetaStringBuilder identifier;
		protected TransferCalculation.TransferCalculationBuilder transferCalculation;
	
		public TransferBaseBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaStringBuilder getIdentifier() {
			return identifier;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateIdentifier() {
			FieldWithMetaStringBuilder result;
			if (identifier!=null) {
				result = identifier;
			}
			else {
				result = identifier = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public TransferCalculation.TransferCalculationBuilder getTransferCalculation() {
			return transferCalculation;
		}
		
		@Override
		public TransferCalculation.TransferCalculationBuilder getOrCreateTransferCalculation() {
			TransferCalculation.TransferCalculationBuilder result;
			if (transferCalculation!=null) {
				result = transferCalculation;
			}
			else {
				result = transferCalculation = TransferCalculation.builder();
			}
			
			return result;
		}
		
	
		@Override
		public TransferBase.TransferBaseBuilder setIdentifier(FieldWithMetaString identifier) {
			this.identifier = identifier==null?null:identifier.toBuilder();
			return this;
		}
		
		@Override
		public TransferBase.TransferBaseBuilder setIdentifierValue(String identifier) {
			this.getOrCreateIdentifier().setValue(identifier);
			return this;
		}
		@Override
		public TransferBase.TransferBaseBuilder setTransferCalculation(TransferCalculation transferCalculation) {
			this.transferCalculation = transferCalculation==null?null:transferCalculation.toBuilder();
			return this;
		}
		
		@Override
		public TransferBase build() {
			return new TransferBase.TransferBaseImpl(this);
		}
		
		@Override
		public TransferBase.TransferBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferBase.TransferBaseBuilder prune() {
			if (identifier!=null && !identifier.prune().hasData()) identifier = null;
			if (transferCalculation!=null && !transferCalculation.prune().hasData()) transferCalculation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null) return true;
			if (getTransferCalculation()!=null && getTransferCalculation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TransferBase.TransferBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TransferBase.TransferBaseBuilder o = (TransferBase.TransferBaseBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::setIdentifier);
			merger.mergeRosetta(getTransferCalculation(), o.getTransferCalculation(), this::setTransferCalculation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TransferBase _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(transferCalculation, _that.getTransferCalculation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (transferCalculation != null ? transferCalculation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TransferBaseBuilder {" +
				"identifier=" + this.identifier + ", " +
				"transferCalculation=" + this.transferCalculation +
			'}';
		}
	}
}
