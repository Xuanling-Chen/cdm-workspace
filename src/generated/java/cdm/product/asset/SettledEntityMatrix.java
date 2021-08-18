package cdm.product.asset;

import cdm.product.asset.meta.SettledEntityMatrixMeta;
import cdm.product.asset.metafields.FieldWithMetaSettledEntityMatrixSourceEnum;
import cdm.product.asset.metafields.FieldWithMetaSettledEntityMatrixSourceEnum.FieldWithMetaSettledEntityMatrixSourceEnumBuilder;
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
 * A class to specify the Relevant Settled Entity Matrix.
 * @version ${project.version}
 */
@RosettaClass

public interface SettledEntityMatrix extends RosettaModelObject {
	SettledEntityMatrix build();
	SettledEntityMatrix.SettledEntityMatrixBuilder toBuilder();
	
	/**
	 * Relevant settled entity matrix source.
	 */
	FieldWithMetaSettledEntityMatrixSourceEnum getMatrixSource();
	/**
	 * Specifies the publication date of the applicable version of the matrix. When this element is omitted, the Standard Terms Supplement defines rules for which version of the matrix is applicable.
	 */
	Date getPublicationDate();
	final static SettledEntityMatrixMeta metaData = new SettledEntityMatrixMeta();
	
	@Override
	default RosettaMetaData<? extends SettledEntityMatrix> metaData() {
		return metaData;
	} 
			
	static SettledEntityMatrix.SettledEntityMatrixBuilder builder() {
		return new SettledEntityMatrix.SettledEntityMatrixBuilderImpl();
	}
	
	default Class<? extends SettledEntityMatrix> getType() {
		return SettledEntityMatrix.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("publicationDate"), Date.class, getPublicationDate(), this);
		
		processRosetta(path.newSubPath("matrixSource"), processor, FieldWithMetaSettledEntityMatrixSourceEnum.class, getMatrixSource());
	}
	
	
	interface SettledEntityMatrixBuilder extends SettledEntityMatrix, RosettaModelObjectBuilder {
		FieldWithMetaSettledEntityMatrixSourceEnumBuilder getOrCreateMatrixSource();
		FieldWithMetaSettledEntityMatrixSourceEnumBuilder getMatrixSource();
		SettledEntityMatrix.SettledEntityMatrixBuilder setMatrixSource(FieldWithMetaSettledEntityMatrixSourceEnum matrixSource);
		SettledEntityMatrix.SettledEntityMatrixBuilder setMatrixSourceValue(SettledEntityMatrixSourceEnum matrixSource);
		SettledEntityMatrix.SettledEntityMatrixBuilder setPublicationDate(Date publicationDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("publicationDate"), Date.class, getPublicationDate(), this);
			
			processRosetta(path.newSubPath("matrixSource"), processor, FieldWithMetaSettledEntityMatrixSourceEnumBuilder.class, getMatrixSource());
		}
		
	}
	
	//SettledEntityMatrix.SettledEntityMatrixImpl
	class SettledEntityMatrixImpl implements SettledEntityMatrix {
		private final FieldWithMetaSettledEntityMatrixSourceEnum matrixSource;
		private final Date publicationDate;
		
		protected SettledEntityMatrixImpl(SettledEntityMatrix.SettledEntityMatrixBuilder builder) {
			this.matrixSource = ofNullable(builder.getMatrixSource()).map(f->f.build()).orElse(null);
			this.publicationDate = builder.getPublicationDate();
		}
		
		@Override
		public FieldWithMetaSettledEntityMatrixSourceEnum getMatrixSource() {
			return matrixSource;
		}
		
		@Override
		public Date getPublicationDate() {
			return publicationDate;
		}
		
		@Override
		public SettledEntityMatrix build() {
			return this;
		}
		
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder toBuilder() {
			SettledEntityMatrix.SettledEntityMatrixBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettledEntityMatrix.SettledEntityMatrixBuilder builder) {
			ofNullable(getMatrixSource()).ifPresent(builder::setMatrixSource);
			ofNullable(getPublicationDate()).ifPresent(builder::setPublicationDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettledEntityMatrix _that = getType().cast(o);
		
			if (!Objects.equals(matrixSource, _that.getMatrixSource())) return false;
			if (!Objects.equals(publicationDate, _that.getPublicationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (matrixSource != null ? matrixSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (publicationDate != null ? publicationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettledEntityMatrix {" +
				"matrixSource=" + this.matrixSource + ", " +
				"publicationDate=" + this.publicationDate +
			'}';
		}
	}
	
	//SettledEntityMatrix.SettledEntityMatrixBuilderImpl
	class SettledEntityMatrixBuilderImpl implements SettledEntityMatrix.SettledEntityMatrixBuilder {
	
		protected FieldWithMetaSettledEntityMatrixSourceEnumBuilder matrixSource;
		protected Date publicationDate;
	
		public SettledEntityMatrixBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaSettledEntityMatrixSourceEnumBuilder getMatrixSource() {
			return matrixSource;
		}
		
		@Override
		public FieldWithMetaSettledEntityMatrixSourceEnumBuilder getOrCreateMatrixSource() {
			FieldWithMetaSettledEntityMatrixSourceEnumBuilder result;
			if (matrixSource!=null) {
				result = matrixSource;
			}
			else {
				result = matrixSource = FieldWithMetaSettledEntityMatrixSourceEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public Date getPublicationDate() {
			return publicationDate;
		}
		
	
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder setMatrixSource(FieldWithMetaSettledEntityMatrixSourceEnum matrixSource) {
			this.matrixSource = matrixSource==null?null:matrixSource.toBuilder();
			return this;
		}
		
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder setMatrixSourceValue(SettledEntityMatrixSourceEnum matrixSource) {
			this.getOrCreateMatrixSource().setValue(matrixSource);
			return this;
		}
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder setPublicationDate(Date publicationDate) {
			this.publicationDate = publicationDate==null?null:publicationDate;
			return this;
		}
		
		@Override
		public SettledEntityMatrix build() {
			return new SettledEntityMatrix.SettledEntityMatrixImpl(this);
		}
		
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder prune() {
			if (matrixSource!=null && !matrixSource.prune().hasData()) matrixSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMatrixSource()!=null) return true;
			if (getPublicationDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettledEntityMatrix.SettledEntityMatrixBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SettledEntityMatrix.SettledEntityMatrixBuilder o = (SettledEntityMatrix.SettledEntityMatrixBuilder) other;
			
			merger.mergeRosetta(getMatrixSource(), o.getMatrixSource(), this::setMatrixSource);
			
			merger.mergeBasic(getPublicationDate(), o.getPublicationDate(), this::setPublicationDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SettledEntityMatrix _that = getType().cast(o);
		
			if (!Objects.equals(matrixSource, _that.getMatrixSource())) return false;
			if (!Objects.equals(publicationDate, _that.getPublicationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (matrixSource != null ? matrixSource.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (publicationDate != null ? publicationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettledEntityMatrixBuilder {" +
				"matrixSource=" + this.matrixSource + ", " +
				"publicationDate=" + this.publicationDate +
			'}';
		}
	}
}
