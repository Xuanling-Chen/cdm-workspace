package cdm.legalagreement.common;

import cdm.legalagreement.common.meta.ContractualMatrixMeta;
import cdm.legalagreement.common.metafields.FieldWithMetaMatrixTermEnum;
import cdm.legalagreement.common.metafields.FieldWithMetaMatrixTermEnum.FieldWithMetaMatrixTermEnumBuilder;
import cdm.legalagreement.common.metafields.FieldWithMetaMatrixTypeEnum;
import cdm.legalagreement.common.metafields.FieldWithMetaMatrixTypeEnum.FieldWithMetaMatrixTypeEnumBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface ContractualMatrix extends RosettaModelObject {
	ContractualMatrix build();
	ContractualMatrix.ContractualMatrixBuilder toBuilder();
	
	/**
	 * Defines any applicable key into the relevant matrix. For example, the Transaction Type would be the single term required for the Credit Derivatives Physical Settlement Matrix. This element should be omitted in the case of the 2000 ISDA Definitions Settlement Matrix for Early Termination and Swaptions.
	 */
	FieldWithMetaMatrixTermEnum getMatrixTerm();
	/**
	 * Identifies the form of applicable matrix.
	 */
	FieldWithMetaMatrixTypeEnum getMatrixType();
	/**
	 * Specifies the publication date of the applicable version of the matrix. When this element is omitted, the ISDA supplemental language for incorporation of the relevant matrix will generally define rules for which version of the matrix is applicable.
	 */
	Date getPublicationDate();
	final static ContractualMatrixMeta metaData = new ContractualMatrixMeta();
	
	@Override
	default RosettaMetaData<? extends ContractualMatrix> metaData() {
		return metaData;
	} 
			
	static ContractualMatrix.ContractualMatrixBuilder builder() {
		return new ContractualMatrix.ContractualMatrixBuilderImpl();
	}
	
	default Class<? extends ContractualMatrix> getType() {
		return ContractualMatrix.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("publicationDate"), Date.class, getPublicationDate(), this);
		
		processRosetta(path.newSubPath("matrixTerm"), processor, FieldWithMetaMatrixTermEnum.class, getMatrixTerm());
		processRosetta(path.newSubPath("matrixType"), processor, FieldWithMetaMatrixTypeEnum.class, getMatrixType());
	}
	
	
	interface ContractualMatrixBuilder extends ContractualMatrix, RosettaModelObjectBuilder {
		FieldWithMetaMatrixTermEnumBuilder getOrCreateMatrixTerm();
		FieldWithMetaMatrixTermEnumBuilder getMatrixTerm();
		FieldWithMetaMatrixTypeEnumBuilder getOrCreateMatrixType();
		FieldWithMetaMatrixTypeEnumBuilder getMatrixType();
		ContractualMatrix.ContractualMatrixBuilder setMatrixTerm(FieldWithMetaMatrixTermEnum matrixTerm);
		ContractualMatrix.ContractualMatrixBuilder setMatrixTermValue(MatrixTermEnum matrixTerm);
		ContractualMatrix.ContractualMatrixBuilder setMatrixType(FieldWithMetaMatrixTypeEnum matrixType);
		ContractualMatrix.ContractualMatrixBuilder setMatrixTypeValue(MatrixTypeEnum matrixType);
		ContractualMatrix.ContractualMatrixBuilder setPublicationDate(Date publicationDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("publicationDate"), Date.class, getPublicationDate(), this);
			
			processRosetta(path.newSubPath("matrixTerm"), processor, FieldWithMetaMatrixTermEnumBuilder.class, getMatrixTerm());
			processRosetta(path.newSubPath("matrixType"), processor, FieldWithMetaMatrixTypeEnumBuilder.class, getMatrixType());
		}
		
	}
	
	//ContractualMatrix.ContractualMatrixImpl
	class ContractualMatrixImpl implements ContractualMatrix {
		private final FieldWithMetaMatrixTermEnum matrixTerm;
		private final FieldWithMetaMatrixTypeEnum matrixType;
		private final Date publicationDate;
		
		protected ContractualMatrixImpl(ContractualMatrix.ContractualMatrixBuilder builder) {
			this.matrixTerm = ofNullable(builder.getMatrixTerm()).map(f->f.build()).orElse(null);
			this.matrixType = ofNullable(builder.getMatrixType()).map(f->f.build()).orElse(null);
			this.publicationDate = builder.getPublicationDate();
		}
		
		@Override
		public FieldWithMetaMatrixTermEnum getMatrixTerm() {
			return matrixTerm;
		}
		
		@Override
		public FieldWithMetaMatrixTypeEnum getMatrixType() {
			return matrixType;
		}
		
		@Override
		public Date getPublicationDate() {
			return publicationDate;
		}
		
		@Override
		public ContractualMatrix build() {
			return this;
		}
		
		@Override
		public ContractualMatrix.ContractualMatrixBuilder toBuilder() {
			ContractualMatrix.ContractualMatrixBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractualMatrix.ContractualMatrixBuilder builder) {
			ofNullable(getMatrixTerm()).ifPresent(builder::setMatrixTerm);
			ofNullable(getMatrixType()).ifPresent(builder::setMatrixType);
			ofNullable(getPublicationDate()).ifPresent(builder::setPublicationDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractualMatrix _that = getType().cast(o);
		
			if (!Objects.equals(matrixTerm, _that.getMatrixTerm())) return false;
			if (!Objects.equals(matrixType, _that.getMatrixType())) return false;
			if (!Objects.equals(publicationDate, _that.getPublicationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (matrixTerm != null ? matrixTerm.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (matrixType != null ? matrixType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (publicationDate != null ? publicationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractualMatrix {" +
				"matrixTerm=" + this.matrixTerm + ", " +
				"matrixType=" + this.matrixType + ", " +
				"publicationDate=" + this.publicationDate +
			'}';
		}
	}
	
	//ContractualMatrix.ContractualMatrixBuilderImpl
	class ContractualMatrixBuilderImpl implements ContractualMatrix.ContractualMatrixBuilder {
	
		protected FieldWithMetaMatrixTermEnumBuilder matrixTerm;
		protected FieldWithMetaMatrixTypeEnumBuilder matrixType;
		protected Date publicationDate;
	
		public ContractualMatrixBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaMatrixTermEnumBuilder getMatrixTerm() {
			return matrixTerm;
		}
		
		@Override
		public FieldWithMetaMatrixTermEnumBuilder getOrCreateMatrixTerm() {
			FieldWithMetaMatrixTermEnumBuilder result;
			if (matrixTerm!=null) {
				result = matrixTerm;
			}
			else {
				result = matrixTerm = FieldWithMetaMatrixTermEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaMatrixTypeEnumBuilder getMatrixType() {
			return matrixType;
		}
		
		@Override
		public FieldWithMetaMatrixTypeEnumBuilder getOrCreateMatrixType() {
			FieldWithMetaMatrixTypeEnumBuilder result;
			if (matrixType!=null) {
				result = matrixType;
			}
			else {
				result = matrixType = FieldWithMetaMatrixTypeEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public Date getPublicationDate() {
			return publicationDate;
		}
		
	
		@Override
		public ContractualMatrix.ContractualMatrixBuilder setMatrixTerm(FieldWithMetaMatrixTermEnum matrixTerm) {
			this.matrixTerm = matrixTerm==null?null:matrixTerm.toBuilder();
			return this;
		}
		
		@Override
		public ContractualMatrix.ContractualMatrixBuilder setMatrixTermValue(MatrixTermEnum matrixTerm) {
			this.getOrCreateMatrixTerm().setValue(matrixTerm);
			return this;
		}
		@Override
		public ContractualMatrix.ContractualMatrixBuilder setMatrixType(FieldWithMetaMatrixTypeEnum matrixType) {
			this.matrixType = matrixType==null?null:matrixType.toBuilder();
			return this;
		}
		
		@Override
		public ContractualMatrix.ContractualMatrixBuilder setMatrixTypeValue(MatrixTypeEnum matrixType) {
			this.getOrCreateMatrixType().setValue(matrixType);
			return this;
		}
		@Override
		public ContractualMatrix.ContractualMatrixBuilder setPublicationDate(Date publicationDate) {
			this.publicationDate = publicationDate==null?null:publicationDate;
			return this;
		}
		
		@Override
		public ContractualMatrix build() {
			return new ContractualMatrix.ContractualMatrixImpl(this);
		}
		
		@Override
		public ContractualMatrix.ContractualMatrixBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractualMatrix.ContractualMatrixBuilder prune() {
			if (matrixTerm!=null && !matrixTerm.prune().hasData()) matrixTerm = null;
			if (matrixType!=null && !matrixType.prune().hasData()) matrixType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMatrixTerm()!=null) return true;
			if (getMatrixType()!=null) return true;
			if (getPublicationDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractualMatrix.ContractualMatrixBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractualMatrix.ContractualMatrixBuilder o = (ContractualMatrix.ContractualMatrixBuilder) other;
			
			merger.mergeRosetta(getMatrixTerm(), o.getMatrixTerm(), this::setMatrixTerm);
			merger.mergeRosetta(getMatrixType(), o.getMatrixType(), this::setMatrixType);
			
			merger.mergeBasic(getPublicationDate(), o.getPublicationDate(), this::setPublicationDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractualMatrix _that = getType().cast(o);
		
			if (!Objects.equals(matrixTerm, _that.getMatrixTerm())) return false;
			if (!Objects.equals(matrixType, _that.getMatrixType())) return false;
			if (!Objects.equals(publicationDate, _that.getPublicationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (matrixTerm != null ? matrixTerm.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (matrixType != null ? matrixType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (publicationDate != null ? publicationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractualMatrixBuilder {" +
				"matrixTerm=" + this.matrixTerm + ", " +
				"matrixType=" + this.matrixType + ", " +
				"publicationDate=" + this.publicationDate +
			'}';
		}
	}
}
